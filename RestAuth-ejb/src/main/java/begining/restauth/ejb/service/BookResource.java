/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.service;

import begining.restauth.ejb.bean.BookBean;
import begining.restauth.ejb.validation.BookValidation;
import begining.restauth.ejb.validation.ResponseValidation;
import begining.restauth.jpa.entity.BookEntity;
import com.google.gson.Gson;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.BeanParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Eiichi Tanaka
 */
@Path("books")
@Stateless
@Local(BookResourceLocal.class)
//@DeclareRolesの宣言なしでも正常に動作
public class BookResource implements BookResourceLocal 
{
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(BookResource.class.getName());
    @EJB
    private BookBean bookBean;
    @Context
    private SecurityContext securityContext;
    @Inject
    private Validator validator;

    @Override
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed({"administrator"})
    public List<BookEntity> getBooks() {
        final Principal p = securityContext.getUserPrincipal();
        logger.log(Level.INFO, "{0} - {1}", 
                new String[]{"BookResource#getBooks", p.getName()});
        return bookBean.getBooksService();
    }
    
    @Override
    @GET
    @Path("{isbn}")
    //@Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed({"administrator", "general"})
    public Response getBook (@BeanParam final BookValidation book) {
        Response response;
        
        final Principal p = securityContext.getUserPrincipal();
        logger.log(Level.INFO, "{0} - principal:{1} - isbn:{2}",
                new String[]{
                    "BookResource#getBook", 
                    p.getName(), 
                    book.getIsbn()});
        
        //バリデーション実行
        Set<ConstraintViolation<BookValidation>> errorSet =
                validator.validate(book);
        
        if (errorSet.size() > 0) {
            final StringBuilder sb = new StringBuilder();
            final List<String> messages = new ArrayList<>();
            for (final ConstraintViolation<BookValidation> error : errorSet) {
                messages.add(error.getMessage());
                logger.log(Level.WARNING, "{0}", error.getMessage());
            }
            
            final ResponseValidation rv = new ResponseValidation();
            rv.setMessages(messages);
            
            //レスポンス(BAD_REQUEST)
            response =  Response.status(
                    Response.Status.BAD_REQUEST).entity("Validation Error").build();
        } else {
            final BookEntity be = bookBean.getBookService(book.getIsbn());
            if (be == null) {
                //レスポンス(NOT_FOUND)
                response = Response.status(
                        Response.Status.NOT_FOUND).entity("BookEntity Not Found").build();
            } else {
                //レスポンス(OK)
                Gson gson = new Gson();
                String json = gson.toJson(be);
                response = Response.ok(json, MediaType.APPLICATION_JSON).build();
            }
        }

        return response;
    }
}

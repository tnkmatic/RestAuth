/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.service;

import begining.restauth.ejb.bean.BookBean;
import begining.restauth.jpa.entity.Book;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Eiichi Tanaka
 */
@Path("books")
@Stateless
@Local(BookResourceLocal.class)
//@DeclareRolesの宣言なしでも正常に動作
public class BookResource implements BookResourceLocal {
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(BookResource.class.getName());
    @EJB
    private BookBean bookBean;
    @Context
    private SecurityContext securityContext;

    @Override
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed({"administrator"})
    public List<Book> getAllBooks() {
        final Principal p = securityContext.getUserPrincipal();
        logger.log(Level.INFO, "{0}", new String[]{p.getName()});
        return bookBean.getAllBooks();
    }
    
    @Override
    @GET
    @Path("{bookId}")
    @Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed({"administrator", "general"})
    public Book getBook(@PathParam("bookId") Long id) {
        return null;
    }
}

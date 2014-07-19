/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.service;

import begining.restauth.ejb.validation.BookValidation;
import begining.restauth.jpa.entity.BookEntity;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author Eiichi Tanaka
 */
public interface BookResourceLocal {
    public List<BookEntity> getBooks();
    public Response getBook(final BookValidation book);
}

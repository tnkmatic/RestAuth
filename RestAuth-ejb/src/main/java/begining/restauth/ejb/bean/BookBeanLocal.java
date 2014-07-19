/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.bean;

import begining.restauth.jpa.entity.BookEntity;
import java.util.List;

/**
 *
 * @author Eiichi Tanaka
 */
public interface BookBeanLocal {
    public List<BookEntity> getBooksService();
    public BookEntity getBookService(final String isbn);
    public void createBookService(final BookEntity book);
}

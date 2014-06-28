/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.service;

import begining.restauth.jpa.entity.Book;
import java.util.List;

/**
 *
 * @author Eiichi Tanaka
 */
public interface BookResourceLocal {
    public List<Book> getAllBooks();
    public Book getBook(Long id);
    
}

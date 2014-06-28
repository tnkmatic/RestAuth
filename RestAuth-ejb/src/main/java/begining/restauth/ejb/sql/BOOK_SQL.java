/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.sql;

/**
 *
 * @author Eiichi Tanaka
 */
public class BOOK_SQL {
    public final static String PARAM_BOOK_ISBN = "isbn";
    public final static String PARAM_BOOK_TITLE = "title";
    
    //全件検索クエリ    
    public final static String NAMED_FIND_ALL_BOOKS = "findAllBooks";
    public final static String QUERY_FIND_ALL_BOOKS = "SELECT b FROM Book b";
    
    //ISBN指定クエリ
    public final static String NAMED_FIND_BOOK_BY_ISBN = "findBookByIsbn";
    public final static String QUERY_FIND_BOOK_BY_ISBN = 
            "SELECT b FROM Book b WHERE b.isbn = :" + PARAM_BOOK_ISBN;
}

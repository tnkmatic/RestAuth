/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.bean;

import begining.restauth.ejb.sql.BOOK_SQL;
import begining.restauth.jpa.entity.Book;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Eiichi Tanaka
 */
@Stateless
@LocalBean
@Local(BookBeanLocal.class)
//@DeclareRolesがなくても正常に動作
public class BookBean implements BookBeanLocal
{
    private java.util.logging.Logger logger = 
            java.util.logging.Logger.getLogger(BookBean.class.getName());    
    @PersistenceContext(unitName = "begining_RestAuth-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;    
    @Resource
    private SessionContext sessionContext;
    
    @Override
    public List<Book> getAllBooks() {
        final Principal p = sessionContext.getCallerPrincipal();
        logger.log(Level.INFO, "{0}", new String[]{p.getName()});
        
        //リスト取得
        Query q = em.createNamedQuery(BOOK_SQL.NAMED_FIND_ALL_BOOKS);        
        final List<Book> books = q.getResultList();

        return books;
    }
    
    @Override
    public Book getBook() {
        return null;
    }

    @Override
    public void createBook(Book book) {
        //
    }
}

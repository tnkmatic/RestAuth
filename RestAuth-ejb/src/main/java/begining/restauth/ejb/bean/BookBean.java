/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.bean;

import begining.restauth.ejb.sql.BOOK_SQL;
import begining.restauth.jpa.entity.BookEntity;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public List<BookEntity> getBooksService() {
        final Principal p = sessionContext.getCallerPrincipal();
        logger.log(Level.INFO, "{0} - {1}", 
                new String[]{"BookBean#getBooksService", p.getName()});
        
        //リスト取得
        Query q = em.createNamedQuery(BOOK_SQL.NAMED_FIND_ALL_BOOKS);        
        final List<BookEntity> books = q.getResultList();

        return books;
    }
    
    @Override
    public BookEntity getBookService(final String isbn) {
        final Principal p = sessionContext.getCallerPrincipal();
        logger.log(Level.INFO, "{0} - {1}", 
                new String[]{"BookBean#getBookService", p.getName()});
        
        //指定のBookを取得
        BookEntity book = new BookEntity();
        try {
            Query q = em.createNamedQuery(BOOK_SQL.NAMED_FIND_BOOK_BY_ISBN);
            q.setParameter(BOOK_SQL.PARAM_BOOK_ISBN, isbn);
            book = (BookEntity) q.getSingleResult();
        } catch (NoResultException ex) {
            logger.log(Level.WARNING, 
                    "No Result : isbn = {0}", isbn);
        }

        //検索結果のログ出力
        if (book.getId() != null) {
            logger.log(Level.INFO
                ,"id={0}, isbn={1}, title={2}"
                ,new String[] {
                    book.getId().toString(),
                    book.getIsbn(),
                    book.getTitle()
                });
        }

        return book;
    }

    @Override
    public void createBookService(BookEntity book) {
        //
    }
}

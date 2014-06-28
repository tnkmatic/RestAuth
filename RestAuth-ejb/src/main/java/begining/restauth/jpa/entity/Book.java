/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.jpa.entity;

import begining.restauth.ejb.sql.BOOK_SQL;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi Tanaka
 */
@Entity
@XmlRootElement
@Table(name = "BOOK503")
@NamedQueries({
    @NamedQuery(
            name  = BOOK_SQL.NAMED_FIND_ALL_BOOKS,
            query = BOOK_SQL.QUERY_FIND_ALL_BOOKS),
    @NamedQuery(
            name  = BOOK_SQL.NAMED_FIND_BOOK_BY_ISBN,
            query = BOOK_SQL.QUERY_FIND_BOOK_BY_ISBN)
})
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    private Float price;
    @Column(length = 2000)
    private String description;
    private String isbn;
    private Integer nbOfPage;
    private Boolean illustration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Boolean isIllustration() {
        return illustration;
    }

    public void setIllustration(Boolean illustration) {
        this.illustration = illustration;
    }
}

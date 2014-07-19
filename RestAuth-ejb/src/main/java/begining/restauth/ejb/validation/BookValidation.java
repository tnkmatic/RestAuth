/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.validation;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.PathParam;

/**
 *
 * @author Eiichi Tanaka
 */
public class BookValidation {
    @PathParam("isbn")
    @Size(min = 1, max = 10, message = "isbn must be less than 11")
    @Pattern(regexp = "^[0-9]*", message = "isbn must be number")
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package begining.restauth.ejb.validation;

import java.util.List;

/**
 *
 * @author Eiichi Tanaka
 */
public class ResponseValidation {
    private List<ErrorValidation> error;

    public List<ErrorValidation> getError() {
        return error;
    }

    public void setError(List<ErrorValidation> error) {
        this.error = error;
    }
}

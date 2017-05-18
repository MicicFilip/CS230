/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz09;

import javax.inject.Inject;

/**
 *
 * @author Filip
 */
@ObelezenaOblasZrna
public class TradStudentController {

    @Inject
    private TradStudent tradStudent;

    public TradStudent getPotrosac() {
        return tradStudent;
    }

    public void setPotrosac(TradStudent tradStudent) {
        this.tradStudent = tradStudent;
    }

    public String navigateToConfirmation() {
//In a real application we would
//Save customer data to the database here.
        return "potvrda";
    }

}

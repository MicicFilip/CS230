/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz09;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Filip
 */
@PovezivanjeLoggingPresretaca
@ObelezenaOblasZrna
public class IntStudentController {

    private static final Logger logger = Logger.getLogger(IntStudentController.class.getName());
    @Inject
    @Int
    private TradStudent tradStudent;

    public String savePotrosac() {
        IntStudent intStudent = (IntStudent) tradStudent;
        logger.log(Level.INFO, "Cuvaju se sledece informacije \n"
                + "{0} {1}, broj indexa = {2}",
                new Object[]{intStudent.getIme(),
                    intStudent.getPrezime(),
                    intStudent.getBrIndex()});
//If this was a real application, we would have code to save
//customer data to the database here.
        return "int_student_potvrda";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz09;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Filip
 */
@PovezivanjeLoggingPresretaca
@Interceptor
public class LoggingPresretac implements Serializable {

    private static final Logger logger = Logger.getLogger(LoggingPresretac.class.getName());

    @AroundInvoke
    public Object logMethodCall(InvocationContext invocationContext)
            throws Exception {
        logger.log(Level.INFO, new StringBuilder("Ulazak ").append(
                invocationContext.getMethod().getName()).append(
                " metoda").toString());
        Object retVal = invocationContext.proceed();
        logger.log(Level.INFO, new StringBuilder("Izlazak ").append(
                invocationContext.getMethod().getName()).append(
                " metoda").toString());
        return retVal;
    }

}

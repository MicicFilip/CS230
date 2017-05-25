/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz10;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Filip
 */
@Named
@RequestScoped
public class JmsPorukaModel {

    private String msgText;

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

}

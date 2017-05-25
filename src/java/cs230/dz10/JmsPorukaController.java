/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz10;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author Filip
 */
@Named
@RequestScoped
public class JmsPorukaController {

    @Inject
    private JmsPorukaModel jmsPorukaModel;

    @Resource(mappedName = "jms/myQueue")
    private Queue mojRed;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    public String sendMsg() {
        sendJMSMessageToMojRed(jmsPorukaModel.getMsgText());

        if (jmsPorukaModel.getMsgText().equals("OOP")) {
            System.out.println("Ovo je tacan odgovor");

            return "potvrda";
        } else if (jmsPorukaModel.getMsgText().equals("Procedural")) {
            System.out.println("Ovo je netacan odgovor");

            return "potvrda";

        }

        return "potvrda";
    }

    private void sendJMSMessageToMojRed(String messageData) {
        context.createProducer().send(mojRed, messageData);
    }
}

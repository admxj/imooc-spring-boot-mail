package com.admxj.spring.SpringDemo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void send(String message){
        jmsTemplate.send("me-destination", new Msg());

    }
}

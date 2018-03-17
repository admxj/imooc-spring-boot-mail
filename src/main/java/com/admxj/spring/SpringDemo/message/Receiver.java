package com.admxj.spring.SpringDemo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "me-destination")
    public void receiveMessage(String message){
        logger.info("接收到 <" + message + ">");
    }

}

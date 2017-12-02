package com.mq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author
 * @create 2017-12-02 21:39
 **/
public class MessageProducer {

    @Autowired
    @Qualifier("amqpTemplate")
    private AmqpTemplate amqpTemplate;

    @Autowired
    @Qualifier("amqpTemplate2")
    private AmqpTemplate amqpTemplate2;

    public void sendMessage(String message){
        amqpTemplate.convertAndSend("yellow",message);

        amqpTemplate.convertAndSend("blue",message);

        amqpTemplate2.convertAndSend("color.aaaaa",message);
    }
}

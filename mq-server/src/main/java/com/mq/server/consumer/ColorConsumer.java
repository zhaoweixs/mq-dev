package com.mq.server.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/11/28.
 */
public class ColorConsumer implements MessageListener {

    public void onMessage(Message message) {
        try {
            System.out.println(new String(message.getBody(),"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

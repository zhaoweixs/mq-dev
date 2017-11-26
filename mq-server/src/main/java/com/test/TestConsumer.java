package com.test;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author
 * @create 2017-11-25 18:00
 **/
public class TestConsumer {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.181.134");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("zhaowei");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("my_queue",false,false,false,null);

        System.out.println("consumer waiting for message");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"utf-8");
                System.out.println("receive message: "+message);
            }
        };

        channel.basicConsume("my_queue",true,consumer);
    }
}

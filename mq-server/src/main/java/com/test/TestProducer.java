package com.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author
 * @create 2017-11-25 22:43
 **/
public class TestProducer {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.181.134");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("zhaowei");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("my_queue",false,false,false,null);

        String message = "hello nuerhachi";

        channel.basicPublish("","my_queue",null,message.getBytes());

        System.out.println("message is already send");

        channel.close();

        connection.close();
    }
}

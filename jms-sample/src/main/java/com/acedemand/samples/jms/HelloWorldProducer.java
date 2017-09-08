package com.acedemand.samples.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Pamir on 5/1/2016.
 */
public class HelloWorldProducer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.133:61616");
        javax.jms.Connection connection = connectionFactory.createConnection();


        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        //create destination
        Destination destination = session.createQueue("jms/acedemandQ");

        //Create Producer Destination
        MessageProducer messageProducer = session.createProducer(destination);
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        String text = "Hello World " + Thread.currentThread().getName();

        TextMessage textMessage = session.createTextMessage(text);
        messageProducer.send(textMessage);

        System.out.println("textMessage = " + textMessage);

    }
}

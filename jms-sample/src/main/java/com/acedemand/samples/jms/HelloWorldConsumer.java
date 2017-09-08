package com.acedemand.samples.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Pamir on 5/1/2016.
 */
public class HelloWorldConsumer implements MessageListener {
    public static void main(String[] args) throws JMSException {

        HelloWorldConsumer consumer = new HelloWorldConsumer();
        consumer.listen();
    }

    public void listen() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.64.133:61616");
        javax.jms.Connection connection = connectionFactory.createConnection();


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //create destination
        Destination destination = session.createQueue("jms/acedemandQ");

        //Create Producer Destination
        MessageConsumer messageConsumer = session.createConsumer(destination);
        messageConsumer.setMessageListener(this);
    }

    public void onMessage(Message message) {
        try {
            System.out.println("textMessage = " + ((TextMessage) message).getText());
        } catch (JMSException jmsEx) {
            throw new RuntimeException(jmsEx);
        }
    }
}

package com.xhlx.rabbit;

//import com.forezp.config.RabbitConfig;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;


//@Component
//public class Sender {
//
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//    public void send() {
//        String context = "hello " + new Date();
//        System.out.println("Sender : " + context);
//        rabbitTemplate.convertAndSend(RabbitConfig.queueName, "Hello from RabbitMQ!");
//    }
//
//}
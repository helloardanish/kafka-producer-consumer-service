package com.ar.service.kafkaconsumer.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    @Value("${message.kafka.consumer.topic}")
    private String topic;

    //@KafkaListener(topics = "${message.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    @KafkaListener(topics = "${message.kafka.consumer.topic}")
    public void listen(String message) {
        System.out.println("Received message: " + message);
        // Process the message as needed
    }
}

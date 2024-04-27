package com.ar.service.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ar.service.kafkaconsumer.config.KafkaConsumerConfig;
import com.ar.service.kafkaconsumer.listener.KafkaMessageListener;

@SpringBootApplication
@Import({KafkaConsumerConfig.class, KafkaMessageListener.class})
public class KafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}

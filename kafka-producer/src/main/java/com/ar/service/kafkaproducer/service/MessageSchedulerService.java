package com.ar.service.kafkaproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ar.service.kafkaproducer.service.kafka.KafkaProducerService;

@Service
public class MessageSchedulerService {

    private static final Logger logger = LoggerFactory.getLogger(
        MessageSchedulerService.class
    );


    //@Value("${app.shceduler.cron}")
    //private long cronTimeMillis;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Scheduled(fixedRate = 5000) // 5 seconds
    //@Scheduled(fixedRateString = "${message.shceduler.cron}")
    public void scheduleTask() {
        logger.info("Pushing into kafka");
        kafkaProducerService.sendMessage("Hi, there!");
    }
}
/*


`fixedRate` parameter in the `@Scheduled` annotation specifies the period in milliseconds between the method returns and the next time it's invoked. So, if your task takes longer than 500 milliseconds to execute, it will be invoked less frequently than every 500 milliseconds.

If you want to ensure a fixed delay between the end of the last invocation and the start of the next, use `fixedDelay` instead of `fixedRate`.


 */

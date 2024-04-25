package com.ar.service.kafkaproducer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestMainController {

    private static final Logger logger = LoggerFactory.getLogger(
        RestMainController.class
    );

    @GetMapping("test")
    public String test() {
        logger.info("/test called");
        logger.info("Test");
        return "Success!!";
    }
}

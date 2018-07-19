package com.example.zipkinservicehi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HiController {

    private static final Logger logger = Logger.getLogger(HiController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHome() {
        logger.log(Level.INFO, "calling trace zipkin-service-hi >>> hi");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        logger.log(Level.INFO, "calling trace zipkin-service-hi >>> info");
        return "I'm zipkin-service-hi";
    }
}

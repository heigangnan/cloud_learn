package com.example.zipkinservicemiya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class MiyaController {

    private static final Logger logger = Logger.getLogger(MiyaController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home() {
        logger.log(Level.INFO, "hi is being called >>> miya");
        return "hi, I'm miya!";
    }

    @RequestMapping("/miya")
    public String info() {
        logger.log(Level.INFO, "info is being called! >>> miya");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }
}

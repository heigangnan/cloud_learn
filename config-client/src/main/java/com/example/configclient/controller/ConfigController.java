package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    // 从config-server加载的配置文件
    @Value("${foo}")
    private String foo;

    @RequestMapping("/hi")
    public String hi() {
        return foo;
    }
}

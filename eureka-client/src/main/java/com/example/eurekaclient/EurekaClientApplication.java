package com.example.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient // 表明自己是一个eurekaclient
@EnableDiscoveryClient
@EnableHystrix // 开启断路器
@EnableHystrixDashboard // 开启HystrixDashboard
@EnableCircuitBreaker
public class EurekaClientApplication {

    /**
     * 访问地址 http://localhost:8762/actuator/hystrix.stream   ping 得到的数据
     *
     * locahost:8762/hystrix  图形化界面展示
     *
     */

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

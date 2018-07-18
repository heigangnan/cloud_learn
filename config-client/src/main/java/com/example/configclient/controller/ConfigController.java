package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    /**
     * 配置文件更新后，发送post请求下面的地址，可以动态更新，重新拉取配置（注意：是post请求）
     * http://localhost:8881/actuator/bus-refresh
     * /actuator/bus-refresh接口可以指定服务，
     * 即使用”destination”参数，比如 “/actuator/bus-refresh?destination=customers:**” 即刷新服务名为customers的所有服务。
     * 调用没有反应：查看pom依赖是否正确；controller上是否加了@RefreshScope；是否是post请求
     */

    // 从config-server加载的配置文件
    @Value("${foo}")
    private String foo;

    @RequestMapping("/hi")
    public String hi() {
        return foo;
    }
}

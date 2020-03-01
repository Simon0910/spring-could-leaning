package com.example.eshop;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// 写一个服务，注入RestTemplate服务调用客户端
@Service
public class GreetingService {

    // @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SayHelloService sayHelloService;

    @Value("${server.port}")
    String port;

    @Value("${defaultName}")
    String defaultName;

    // 用SAY-HELLO-SERVICE这个服务名替代实际的ip地址
    // ribbon负载在多个服务实例之间负载均衡，每次调用随机挑选一个实例，然后替换服务名
    public String greeting(String name) {
        // return restTemplate.getForObject("http://SERVICE-SAY-HELLO/sayHello?name=" + name, String.class);

        String result = null;
        if (name != null && name != "") {
            result = sayHelloService.sayHello(name);
        } else {
            result = "hello, this is the default name: " + defaultName;
        }
        result += " , through greeting service from port: " + port;
        return result;
    }

}
package com.concoo.eshop;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/sayHello")
    @HystrixCommand(fallbackMethod = "sayHelloFallback")
    public String sayHello(@RequestParam String name) {
        return "hello, " + name + " from port:" + port;
    }

    public String sayHelloFallback(String name) {
        return "error, " + name + " from port:" + port;
    }
}

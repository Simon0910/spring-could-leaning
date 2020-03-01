package com.concoo.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class HystrixTurbineServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineServiceApplication.class, args);
    }

}

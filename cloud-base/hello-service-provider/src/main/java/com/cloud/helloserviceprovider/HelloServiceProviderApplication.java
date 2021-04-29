package com.cloud.helloserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HelloServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServiceProviderApplication.class, args);
    }

}

package com.cloud.helloserviceprovider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Scanner;

@EnableDiscoveryClient
@SpringBootApplication
public class HelloServiceProviderApplication {

    public static void main(String[] args) {
        //SpringApplication.run(HelloServiceProviderApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        Scanner scanner = new Scanner(System.in);
        builder.properties("server.port=" + scanner.nextInt());
        builder.sources(HelloServiceProviderApplication.class);
        builder.build().run();
    }

}

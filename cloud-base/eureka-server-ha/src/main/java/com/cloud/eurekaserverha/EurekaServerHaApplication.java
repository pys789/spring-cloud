package com.cloud.eurekaserverha;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerHaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerHaApplication.class)
                .web(true).run(args);
    }

}

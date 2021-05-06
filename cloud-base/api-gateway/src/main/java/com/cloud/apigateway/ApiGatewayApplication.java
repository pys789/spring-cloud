package com.cloud.apigateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {
    // 测试地址：http://localhost:5555/api-a-url/feign-consumer
    public static void main(String[] args) {
        //SpringApplication.run(ApiGatewayApplication.class, args);
        new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
    }

}

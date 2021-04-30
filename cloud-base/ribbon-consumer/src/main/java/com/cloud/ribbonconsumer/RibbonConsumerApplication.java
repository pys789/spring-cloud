package com.cloud.ribbonconsumer;

import com.cloud.config.MyRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
// @RibbonClient注解来实现更细粒度的客户端配置
// @RibbonClient(name = "hello-service", configuration = MyRibbonConfig.class)
@EnableCircuitBreaker // 开启断路器功能
public class RibbonConsumerApplication {

    @Bean
    // 客户端负载均衡（启动多个服务提供者，客户端获取服务列表后，均衡访问）
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);

    }

}

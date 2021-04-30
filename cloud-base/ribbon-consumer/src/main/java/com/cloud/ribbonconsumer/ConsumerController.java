package com.cloud.ribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @Description
 * @Date 2021/4/29 16:29
 * @Created by pengys
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping("ribbon-consumer")
    public String helloConsumer() {

        // 使用@LoadBalanced
        ResponseEntity<String> entity = restTemplate.getForEntity("http://hello-service/hello", String.class);

        // 自定义负载均衡
        // ServiceInstance serviceInstance = loadBalancer.choose("hello-service");
        // String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello";
        // ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

        return entity.getBody();
    }

    @RequestMapping("ribbon-consumer2")
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloConsumer2() throws InterruptedException {
        // Hystrix 默认超时时间为2000毫秒
        Thread.sleep(new Random().nextInt(3000));
        // 使用@LoadBalanced
        ResponseEntity<String> entity = restTemplate.getForEntity("http://hello-service/hello", String.class);
        return entity.getBody();
    }

    public String helloFallback() {
        return "error";
    }
}

package com.cloud.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}

package com.cloud.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();

    }
}

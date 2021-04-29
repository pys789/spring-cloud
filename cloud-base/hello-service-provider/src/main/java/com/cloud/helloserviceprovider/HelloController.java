package com.cloud.helloserviceprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2021/4/29 10:58
 * @Created by pengys
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello")
    public String index() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        System.out.println(String.format("/hello,host:%s,service_id:%s",
                instance.getHost(), instance.getServiceId()));
        return "Hello world";
    }
}

package com.cloud.helloserviceprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Date 2021/4/29 10:58
 * @Created by pengys
 */
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        System.out.println(String.format("/hello,host:%s,service_id:%s",
                instance.getHost(), instance.getServiceId()));
        return "Hello world";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello2(@RequestParam String name, @RequestParam Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello3(@RequestBody User user) {
        return "Hello " + user.getName() + "," + user.getAge();
    }


}

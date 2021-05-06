package com.cloud.feignconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Date 2021/5/6 15:59
 * @Created by pengys
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping(value = "/hello")
    String hello();

    // @RequestMapping,@RequestParam必须指定value,不能省略
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
     User hello(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
     String hello(@RequestBody User user);
}

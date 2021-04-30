package com.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description MyRibbonConfig 不放在spring boot启动类的当前包或子包中即可,
 * 否则它将被所有@RibbonClients共享
 * @Date 2021/4/30 13:54
 * @Created by pengys
 */
@Configuration
public class MyRibbonConfig {

    @Bean
    public IRule ribbonRule() {
        //随机负载
        return new RandomRule();
    }

}

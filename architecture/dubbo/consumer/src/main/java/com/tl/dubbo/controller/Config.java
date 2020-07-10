package com.tl.dubbo.controller;

import org.apache.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tianlei on 2019-08-11
 */
@Configuration
public class Config {

//    @Bean
//    ConsumerConfig consumerConfig() {
//        ConsumerConfig consumerConfig  = new ConsumerConfig();
//        consumerConfig.setGroup("default");
////        consumerConfig.setFilter("exception");
//        return consumerConfig;
//    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");
        return registryConfig;
    }

}

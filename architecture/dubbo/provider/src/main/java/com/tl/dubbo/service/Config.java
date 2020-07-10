package com.tl.dubbo.service;

import org.apache.dubbo.config.RegistryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tianlei on 2019-08-11
 */
@Configuration
public class Config {

//    @Bean
//    ProviderConfig providerConfig() {
//        ProviderConfig providerConfig = new ProviderConfig();
//        providerConfig.setGroup("default");
//        providerConfig.setFilter("exceptionFilter");
//        return providerConfig;
//    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");
        return registryConfig;
    }

}

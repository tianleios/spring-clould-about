package com.tl;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tianlei
 * @date 2019/05/22
 */
@SpringBootApplication
@EnableDubbo
public class ProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class);
    }
}

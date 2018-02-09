package com.tl.Bean;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class Config {

    @Bean(name = "testBean")
    String testBean() {

        return "testBean";

    }
}

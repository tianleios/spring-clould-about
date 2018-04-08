package com.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

    @Bean(initMethod = "beanTestInit",destroyMethod = "dest")
    public BeanTest beanTest() {

        BeanTest beanTest = new BeanTest();
        beanTest.name = "tianlei";
        return beanTest;
    }



    public static void main(String[] args) {

        SpringApplication.run(AopApplication.class);
    }
}

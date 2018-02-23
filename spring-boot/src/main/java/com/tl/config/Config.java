package com.tl.config;

import com.tl.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;


//@ImportResource 可以导入xml
public class Config {

    @Bean
    public String testBean() {

        return "testBean";

    }

    @Bean(name = "masterUser")
    public User uer() {

        User masterUser = new User();
        masterUser.setName("Master");
        masterUser.setAge(100);
        masterUser.setId(1L);
        return masterUser;

    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}

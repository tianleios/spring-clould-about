package com.tl.bean;

import com.tl.domain.User;
import org.springframework.context.annotation.Bean;


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

}
package com.tl.bean;

import com.tl.domain.User;
import org.springframework.context.annotation.Bean;

public class Config2 {

    @Bean(name = "masterUser2")
    public User uer() {

        User masterUser = new User();
        masterUser.setName("Master2");
        masterUser.setAge(100);
        masterUser.setId(1L);
        return masterUser;

    }
}

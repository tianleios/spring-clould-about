package com.tl.controller;

import com.tl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

//    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @Autowired
    //可以指定bean的名字
    @Qualifier("masterUser2")
    User user;

    @GetMapping("/test")
    public void test() {
        int a = 10;
    }

}

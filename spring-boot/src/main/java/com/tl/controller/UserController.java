package com.tl.controller;

import com.tl.domain.User;
import com.tl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

//    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @Autowired
    //可以指定bean的名字
    /**/
    @Qualifier("masterUser2")
    User user;

    @Autowired
    IUserService userService;

    @GetMapping("/validation")
    public void test(@Size(min = 5,max = 10) @NotNull String name) {
        int a = 10;


//        this.userService.findUserByName("name");
//        this.userService.findUserByName("name000");

    }


}

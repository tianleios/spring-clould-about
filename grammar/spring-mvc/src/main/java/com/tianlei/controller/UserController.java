package com.tianlei.controller;

import com.tianlei.diy.DIY;
import com.tianlei.spring.Life;
import com.tianlei.spring.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private com.tianlei.controller.Async async;

    @Autowired
    People people;

    @Autowired
    Life life;

    @Autowired
    ApplicationContext applicationContext;

    @Resource
    UserService userService;

    @GetMapping("/test")
    @ResponseBody
    public String test(@DIY String info) {
        async.async();
        System.out.println("另一个人");
        userService.test();
        return "success";
    }



}

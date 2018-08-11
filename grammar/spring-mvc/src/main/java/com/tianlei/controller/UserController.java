package com.tianlei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private com.tianlei.controller.Async async;

    @GetMapping("/test")
    @ResponseBody
    public String test() {

        async.async();
        System.out.println("另一个人");
        return "success";

    }



}

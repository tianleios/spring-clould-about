package com.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AopController {


    @GetMapping("/aop")
    @ResponseBody
    public String aop() {

        System.out.println(" 执行了aop 方法");
        return "aop";
    }

}

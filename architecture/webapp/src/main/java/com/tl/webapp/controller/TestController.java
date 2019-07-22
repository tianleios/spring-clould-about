package com.tl.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by tianlei on 2019/7/22
 */
@RestController
@RequestMapping("/test")
public class TestController  {

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @PostConstruct
    public void init() {
        System.out.println("tianlei");
    }
}

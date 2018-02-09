package com.tl.controller;

import com.tl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;



    @GetMapping("/test")
    public String test() {
        return testService.test();
    }

    @GetMapping("/autor")
    public String autor() {
        return testService.autorInfo();
    }

    @GetMapping("/todo")
    public String todo() {
        return testService.todo();
    }

}

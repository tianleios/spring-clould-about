package com.tl.controller;

import com.tl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/get")
    public String getTest(){

        return "success";

    }

    @PostMapping(value = "/post")
    public Map getTest( String name){

        Map map = new HashMap();
        map.put("name",name);
        return map;

    }



}

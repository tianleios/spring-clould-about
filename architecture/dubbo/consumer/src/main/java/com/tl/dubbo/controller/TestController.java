package com.tl.dubbo.controller;

import com.tl.dubbo.common.service.Provider;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianlei on 2019-07-28
 */
@RestController
@RequestMapping
public class TestController {

    @Reference(url = "dubbo://localhost:20880")
    Provider provider;

    @GetMapping("/test")
    public String test() {
        return provider.sayHi("tl");
    }
}

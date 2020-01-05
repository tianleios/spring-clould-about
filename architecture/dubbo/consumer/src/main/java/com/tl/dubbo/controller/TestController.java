package com.tl.dubbo.controller;

import com.tl.dubbo.common.model.Teacher;
import com.tl.dubbo.common.service.Provider;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianlei on 2019-07-28
 */
@RestController
@RequestMapping
public class TestController {

    @Reference(url = "dubbo://localhost:20880", timeout = 30000000)
    private Provider provider;

    @GetMapping("/test/{content}")
    public String test(@PathVariable("content") String content) {
        Teacher teacher = provider.sayHi(content);
        System.out.println(teacher);

        return teacher.getName();
    }
}

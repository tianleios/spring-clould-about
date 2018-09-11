package com.tianlei.controller;

import com.tianlei.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianlei on 2018/9/4
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/test")
    public void test() {
        userMapper.addName("tianlei");
        int a = 0;
    }
}

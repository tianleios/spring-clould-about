package com.tianlei.controller;

import com.tianlei.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by tianlei on 2018/9/4
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;


    @PostConstruct
    public void init() {
        int a = 0;
    }

    @GetMapping("/test")
    public void test() {
//        userMapper.addName("tianlei");
//       System.out.println(userMapper.selectOne());
        userMapper.selectList();
        int a = 0;

    }



}

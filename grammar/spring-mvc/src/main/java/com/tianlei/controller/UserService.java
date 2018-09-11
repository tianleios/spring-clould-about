package com.tianlei.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tianlei on 2018/9/3
 */
@Service
public class UserService {

    @Resource
    ApplicationContext applicationContext;

    @Resource
    UserController userController;

    public void test() {
        int a = 10;
    }
}

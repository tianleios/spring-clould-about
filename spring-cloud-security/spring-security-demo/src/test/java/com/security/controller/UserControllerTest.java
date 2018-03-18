package com.security.controller;

import com.security.SecurityApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SecurityApplication.class})
public class UserControllerTest {

    @Autowired
    UserController userController;

    @org.junit.Test
    public void login() {

        userController.login();
    }
}
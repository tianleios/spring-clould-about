package com.tl.controller;

import com.tl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianlei on 2019/2/27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping( method = RequestMethod.GET, path = "/add")
    public String insert() {
        userService.insert();
        return "success";
    }
}

package com.cache.controller;

import com.cache.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;



    @GetMapping("/user/{userId}")
    @ResponseBody
    public String userInfo(@PathVariable("userId") String userId) {

        return this.userDao.userInfo(userId);

    }

    @GetMapping("/clear/{userId}")
    @ResponseBody
    public void clearCache(@PathVariable("userId") String userId) {

         this.userDao.clearCache(userId);

    }


}

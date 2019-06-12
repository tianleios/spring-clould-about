package com.tl.sc.controller;

import com.tl.sc.common.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tianlei
 * @date 2019/06/09
 */
@RestController
public class TestController {

    @Autowired
    UserApi userApi;

    @GetMapping("/test")
    public String test() {
       return userApi.getUserName(1L);
    }



}

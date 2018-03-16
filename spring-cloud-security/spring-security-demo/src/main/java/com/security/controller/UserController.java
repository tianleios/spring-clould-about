package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class UserController {

    @GetMapping("/login")
    public String login() {

        return "success";

    }

    @GetMapping("/signup")
    public String signup() {

        return "success";

    }
}

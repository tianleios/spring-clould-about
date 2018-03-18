package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    AuthenticationManager authenticationManager;

//    @Autowired
//    SampleAuthenticationManager authenticationManager;


    //其实是下面这种形式
//    private static AuthenticationManager am = new SampleAuthenticationManager();


    @GetMapping("/user")
//    @PreAuthorize("hasRole('admin')")
    @PreAuthorize("hasAuthority('admin')")
    public String userInfo() {

        return "success";
    }

    @GetMapping("/login")
    public String login() {

        try {

            UsernamePasswordAuthenticationToken request = new UsernamePasswordAuthenticationToken("tianlei","password");
            Authentication result =  authenticationManager.authenticate(request);

            //把认证结果进行存储
            SecurityContextHolder.getContext().setAuthentication(result);

        } catch (AuthenticationException e) {

            System.out.println("Authentication failed: " + e.getMessage());
        }


        return "success";

    }

    @GetMapping("/signup")
    public String signup() {



        return "success";

    }

    public String getCurrentUsername() {

       //第一种方式，也是最简单的
       //获取当前用户信息
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       if (authentication.isAuthenticated()) {
           //已经认证
       }
       return authentication.getName();

       //第二种方式
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            return ((UserDetails) principal).getUsername();
//        }
//
//        if (principal instanceof Principal) {
//            return ((Principal)principal).getName();
//        }
//
//        return String.valueOf(principal);

    }
}

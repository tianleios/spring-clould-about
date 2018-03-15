package com.tianlei.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/user")
public class UserController {


    @PostMapping("/login")
    public String login(String userName, String password) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        subject.login(token);
        return "success";

    }

    @RequiresAuthentication //需要认证过之后
    @RequiresRoles("admin") //需要某个角色
//    @RequiresPermissions(value = {""}) //需要某种权限
//    @RequiresGuest
//    @RequiresUser
    @GetMapping("/admin")
    public String adminOnly() {

        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            throw new RuntimeException("用户需要登录");
        }

        return "admin";

    }
}

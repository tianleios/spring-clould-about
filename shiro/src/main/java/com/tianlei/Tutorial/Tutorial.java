package com.tianlei.Tutorial;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial {

    private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);

    public static void main(String[] args) {

        log.info("My First Apache Shiro Application");

        Factory factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = (SecurityManager) factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");

        if (!currentUser.isAuthenticated()) {

            // 收集用户身份和证明
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("lonestarr", "vespa");
            usernamePasswordToken.setRememberMe(true);

            try {
                currentUser.login(usernamePasswordToken);
                //无异常，说明就是我们想要的!
            } catch (UnknownAccountException uae) {
                //username 不存在，给个错误提示?
            } catch (IncorrectCredentialsException ice) {
                //password 不匹配，再输入?
            } catch (LockedAccountException lae) {
                //账号锁住了，不能登入。给个提示?
            } catch (AuthenticationException ae) {
                //未考虑到的问题 - 错误?
            }

            if (currentUser.hasRole("schwartz")) {
                log.info("May the Schwartz be with you!");
            } else {
                log.info("Hello, mere mortal.");
            }

            //测试一个权限 (非（instance-level）实例级别)
            if (currentUser.isPermitted("lightsaber:weild")) {
                log.info("You may use a lightsaber ring.  Use it wisely.");
            } else {
                log.info("Sorry, lightsaber rings are for schwartz masters only.");
            }

            //一个(非常强大)的实例级别的权限:
            if (currentUser.isPermitted("winnebago:drive:eagle5")) {
                log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                        "Here are the keys - have fun!");
            } else {
                log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
            }

            currentUser.logout();

        }

//        System.exit(0);


    }

}

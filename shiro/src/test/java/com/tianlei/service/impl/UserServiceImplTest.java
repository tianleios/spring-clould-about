package com.tianlei.service.impl;


import com.tianlei.ShiroApplication;
import com.tianlei.domain.User;
import com.tianlei.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShiroApplication.class})

public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    public void findById() {

        User user = this.userService.findById(1002L);
        Assert.assertNotNull(user);
    }

    @Test
    public void save() {

        User user = new User();
        user.setName("tianlei");
        user.setPassword("password");
        this.userService.save(user);

        //
        User user1 = new User();
        user1.setName("yang");
        user1.setPassword("password");
        this.userService.save(user1);

    }

    @Test
    public void findUserPage() {

        this.userService.findUserPage(1,1);

    }

    @Test
    public void findUserDetailByUserName() {

       User user = this.userService.findUserDetailByUserName("tianlei");

    }
}

package com.tl.service.impl;

import com.tl.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RedisServiceTest {

    @Autowired
    RedisService redisService;

    @Test
    public void getValue() {

       String value = redisService.getValue("name");
       int a = 10;
    }

    @Test
    public void setValue() {
    }
}
package com.tianlei.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedisController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/lock")
    public void lock() {
        //分布式锁
        RLock rLock = this.redissonClient.getLock("TEST_LOCK");
        try {

            rLock.lock();
            Thread.sleep(1000);
        } catch (Exception e){

        } finally {

            rLock.unlock();
        }
    }

}

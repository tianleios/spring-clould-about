package com.tianlei.controller;

import org.springframework.stereotype.Component;

@Component
public class Async {

    @org.springframework.scheduling.annotation.Async
    public void async()  {

        try {
            System.out.println("我要睡了");
            Thread.sleep(5000);
            System.out.println("我睡晚了");
        } catch (Exception e) {

        }
    }
}

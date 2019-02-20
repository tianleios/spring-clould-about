package com.tl.service;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianlei on 2019/1/28
 */
@Service
public class Playground implements SmartInitializingSingleton {

    @Autowired
    SpringLookUpTester springLookUpTester;

    @Autowired
    User user;

    @Override
    public void afterSingletonsInstantiated() {
        int a = 0;
    }
}

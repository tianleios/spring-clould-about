package com.tianlei.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tianlei on 2018/8/29
 */
@Component
public class Dog {

    @Autowired
    People people;
}

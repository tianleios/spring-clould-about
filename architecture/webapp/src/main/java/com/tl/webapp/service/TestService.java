package com.tl.webapp.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by tianlei on 2019/7/22
 */
@Service
public class TestService {

    @PostConstruct
    public void init() {
        System.out.println("tianlei TestService");
    }
}

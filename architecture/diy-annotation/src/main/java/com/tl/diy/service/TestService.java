package com.tl.diy.service;

import com.tl.diy.annotation.DIY;
import org.springframework.stereotype.Service;

/**
 * Created by tianlei on 2020/1/17
 */
@Service
public class TestService {

    @DIY
    public DIYService diyService;


    public void test() {

        diyService.getNewMsg();

    }

}

package com.ribbon.controller;

import com.ribbon.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ComputeService computeService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {

        return computeService.addService();

    }
}

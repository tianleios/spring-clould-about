package com.tianlei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tianlei on 2018/12/6
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/index")
    public String view() {
        return "/index";
    }
}

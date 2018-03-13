package com.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class TestController {

    //访问 http://localhost:7080/refresh
    @Value("${from}")
    private String from;

    @GetMapping("/from")
    public String from() {

        return this.from;

    }

}

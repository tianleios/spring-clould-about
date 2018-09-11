package com.tl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHiController {

    @Reference(url = "dubbo://localhost:20880", version = "1")
    private IDubboService dubboService;

    @GetMapping("/hi")

    public String sayHi()    {
       return dubboService.sayHi();
    }

}

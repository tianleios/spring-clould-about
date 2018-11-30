package com.tianlei.controller;

import com.tianlei.diy.DIY;
import com.tianlei.req.Req;
import com.tianlei.spring.Life;
import com.tianlei.spring.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class UserController {

    @Resource
    private com.tianlei.controller.Async async;

    @Autowired
    People people;

    @Autowired
    Life life;

    @Autowired
    ApplicationContext applicationContext;

    @Resource
    UserService userService;

    @Autowired
    Validator validator;

    @PostConstruct
    public void init() {
        Req req = new Req();
        Set<ConstraintViolation<Req>> res = validator.validate(req);

        StringBuilder sb = new StringBuilder();
        res.forEach(c -> {
            sb.append(c.getPropertyPath().toString());
            sb.append(c.getMessage());
            sb.append(",");
            c.getPropertyPath().toString();
        });
        System.out.println(sb.toString());
        int a = 10;
    }

    @GetMapping("/test")
//    @ResponseBody
    public Req test(@RequestParam(required = false) String info) {
        async.async();
        System.out.println("另一个人");
        userService.test();
        Req req = new Req();
        if (info != null) {
            throw new RuntimeException("error");
        }
        return req;
//        return "success";
    }

    @GetMapping("/info")
    public ModelAndView info(@DIY String info) {
        Map<String, String> map = new HashMap();
        map.put("name", "tl");
        map.put("age", "18");
        return new ModelAndView().addAllObjects(map);
    }

    @PostMapping("/val")
    @ResponseBody
    public String val(@Valid @RequestBody Req req) {
        return req.name + req.age;
    }


}

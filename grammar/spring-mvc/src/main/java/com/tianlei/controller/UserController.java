package com.tianlei.controller;

import com.tianlei.diy.DIY;
import com.tianlei.req.Req;
import com.tianlei.spring.Life;
import com.tianlei.spring.People;
import org.springframework.beans.factory.InitializingBean;
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
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController implements InitializingBean {

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
        a = 11;
        try {
            TimeUnit.SECONDS.sleep(1000);
            System.out.println("refresh");
        } catch (InterruptedException e) {
        }
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


    volatile private int a = 10;
    Timer timer = new Timer();


    @Override
    public void afterPropertiesSet() throws Exception {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date().toString() + "-" + a);
            }
        }, 0, 100);
    }
}

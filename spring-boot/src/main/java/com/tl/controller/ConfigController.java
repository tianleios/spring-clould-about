package com.tl.controller;

import com.tl.config.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    // 读取resource 下 application.properties
    @Value("${com.tianlei.name}")
    String name;

    @Value("${com.tianlei.age}")
    Integer age;

    @Value("${com.tianlei.desc}")
    String todo;

    @Value("${com.tianlei.env}")
    String env;

    @Value("${com.tianlei.random}")
    String random;

    @Autowired
    Properties properties;

    public String test() {
        ClassPathXmlApplicationContext obj  = null;
        return "test service";
    }

    @GetMapping("/display")
    public String autorInfo() {

        String str1 = "姓名：" + name + " " + "年龄：" + age + "\n";
        String str2 = "环境：(读取可变配置)" + this.env + "\n";
        String str3 = "类配置：" + properties.getProvince() + properties.getCity() + "\n";
        String str4 = "随机：" + random + "\n";

        String[] rooms = {str1, str2, str3, str4};

        String finalStr = null;
        for (String str : rooms) {
            finalStr = finalStr == null ? "" : finalStr + "<div>" + str + "</div>";
        }
        return finalStr;

    }
}

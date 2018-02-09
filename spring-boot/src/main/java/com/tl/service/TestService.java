package com.tl.service;

import com.tl.config.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestService {

//    @Autowired
//    String testBean;

    @Value("${com.tianlei.name}")
    String name;

    @Value("${com.tianlei.age}")
    Integer age;

    @Value("${com.tianlei.desc}")
    String todo;

    @Value("${com.tianlei.env}")
    String env;

    @Autowired
    Properties properties;

    public String test() {
        return "test service";
    }

    public String autorInfo() {

        String str1 = "姓名：" + name + " " + "年龄：" + age + "\n";
        String str2 = "环境：(读取可变配置)" + this.env + "\n";
        String str3 = "类配置：" + properties.getProvince() + properties.getCity() + "\n";
        return str1 + str2 + str3;

    }

    public String todo() {

        return this.todo;

    }

}

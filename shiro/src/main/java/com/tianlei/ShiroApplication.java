package com.tianlei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tianlei.dao")
public class ShiroApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShiroApplication.class);

        

    }
}

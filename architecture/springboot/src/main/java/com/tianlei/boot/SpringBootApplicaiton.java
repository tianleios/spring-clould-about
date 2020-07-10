package com.tianlei.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * Created by tianlei on 2020/4/1
 */
@SpringBootApplication
public class SpringBootApplicaiton {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootApplicaiton.class);
        springApplication.addListeners(new ApplicationPidFileWriter("~/springBootApplicaiton.pid"));
        springApplication.run(args);
    }
}

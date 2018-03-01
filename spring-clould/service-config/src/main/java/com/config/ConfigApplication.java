package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
//    tianlei-dev.properties  url中tianlei，dev  对应 tianlei-dev
//  启动后 访问：http://localhost:7070/tianlei/dev
    public static void main(String[] args) {

        SpringApplication.run(ConfigApplication.class,args);

    }
}

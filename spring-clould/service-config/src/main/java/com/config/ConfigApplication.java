package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigApplication {
//    service-config-client-dev.properties  service-config-client，dev  对应 service-config-client-dev
//  启动后 访问：
//    http://localhost:7070/service-config-client/dev
//    http://localhost:7070/service-config-client/default
//    http://localhost:7070/service-config-client/test
//    http://localhost:7070/service-config-client/prod
    public static void main(String[] args) {

        SpringApplication.run(ConfigApplication.class,args);

    }
}

package com.tianlei.consul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ConsulApplication implements CommandLineRunner {

    @Value("${address}")
    private String address;

    public static void main(String[] args) {

        SpringApplication.run(ConsulApplication.class);

    }

    @Override
    public void run(String... args) throws Exception {
        int a = 10;
    }
}

package com.auth.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

@EnableOAuth2Sso


//@EnableOAuth2Client 这个应该是授权码模式、或者是 简化模式使用这个

public class AuthClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(AuthClientApplication.class);

    }

}

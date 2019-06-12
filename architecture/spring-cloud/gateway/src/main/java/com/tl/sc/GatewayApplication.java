package com.tl.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;

import java.security.Principal;

/**
 * @author tianlei
 * @date 2019/06/12
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(GatewayApplication.class, args);

    }


    @Bean
    public GlobalFilter customGlobalFilter() {
        return (exchange, chain) -> exchange.getPrincipal()
            .map(Principal::getName)
            .defaultIfEmpty("Default User")
            .map(userName -> {
                //adds header to proxied request
                exchange.getRequest().mutate().header("CUSTOM-REQUEST-HEADER", userName).build();
                return exchange;
            })
            .flatMap(chain::filter);
    }

}

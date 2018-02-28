package com.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {

        return restTemplate.getForEntity("http://SERVICE-COMPUTE/add/100/200", String.class).getBody();

    }

    public String addServiceFallback() {
        return "tianlei error breaker";
    }
}

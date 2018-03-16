package feign.service;

import org.springframework.stereotype.Component;

@Component
public class ComputeClientHystrix implements ComputeClient {

    public Integer add(Integer a, Integer b) {
        return -9999;
    }
}

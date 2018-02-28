package feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SERVICE-COMPUTE",fallback = ComputeClientHystrix.class)
public interface ComputeClient {

//    不要使用GetMapping 不然会报错
    @RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
    public Integer add(@PathVariable("a") Integer a,
                       @PathVariable("b") Integer b);
}

package com.tl.sc.common.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tianlei
 * @date 2019/06/09
 */
@FeignClient(name = "tl-sc-service")
public interface UserApi {

    @RequestMapping("/getUser")
    String getUserName(@RequestParam Long id);

}

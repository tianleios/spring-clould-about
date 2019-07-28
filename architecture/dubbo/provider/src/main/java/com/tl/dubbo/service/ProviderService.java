package com.tl.dubbo.service;

import com.tl.dubbo.common.service.Provider;
import org.apache.dubbo.config.annotation.Service;

/**
 * Created by tianlei on 2019-07-28
 */
@Service(filter = "exceptionFilter")
public class ProviderService  implements Provider {
    @Override
    public String sayHi(String content) {
        if (1 > 0) {
            throw new RuntimeException("tl error");
        }
        return "Hi!" + content;
    }
}

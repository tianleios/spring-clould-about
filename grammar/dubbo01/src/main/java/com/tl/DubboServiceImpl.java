package com.tl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(interfaceClass = IDubboService.class, version = "1")
@Component
public class DubboServiceImpl implements IDubboService {

    @Override
    public String sayHi() {
        return "hi!!!";
    }
}

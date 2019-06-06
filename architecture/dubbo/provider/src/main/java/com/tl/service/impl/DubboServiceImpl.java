package com.tl.service.impl;

import com.tl.common.action.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author tianlei
 * @date 2019/05/23
 */
@Component
@Service
public class DubboServiceImpl implements DubboService {

    @Override
    public void find() {

    }
}

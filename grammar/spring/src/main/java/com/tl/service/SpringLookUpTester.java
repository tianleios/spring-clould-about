package com.tl.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * Created by tianlei on 2019/1/28
 */
@Component
public abstract class SpringLookUpTester {
    // 不实现该方法，会直接向BeanFactory 索要bean
    @Lookup
    abstract public User getUser();

}

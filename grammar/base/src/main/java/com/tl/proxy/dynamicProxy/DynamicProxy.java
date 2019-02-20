package com.tl.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tianlei on 2019/1/30
 */
public class DynamicProxy implements InvocationHandler {
    Subject subject;

    public DynamicProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(subject, args);
    }

}
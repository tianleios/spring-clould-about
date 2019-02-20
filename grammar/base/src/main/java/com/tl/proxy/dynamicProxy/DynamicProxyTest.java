package com.tl.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by tianlei on 2018/9/4
 */
public class DynamicProxyTest {

    public static void main(String[] args) {

        DynamicProxy dynamicProxy = new DynamicProxy(new RealSubject());
        ClassLoader classLoader = dynamicProxy.getClass().getClassLoader();
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, new Class[]{Subject.class}, dynamicProxy);
        subject.visit();
        subject.test();
    }



}

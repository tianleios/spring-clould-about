package com.tl.proxy.dynamicProxy;

/**
 * Created by tianlei on 2019/1/30
 */
public class RealSubject implements Subject {
    @Override
    public void visit() {
        System.out.println("i am boss");
    }

    @Override
    public void test() {
        System.out.println("i am test");
        this.visit();
    }
}

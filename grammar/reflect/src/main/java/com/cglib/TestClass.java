package com.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestClass {

    public void test() {

        System.out.println("hellow word");

    }

    public static void main(final String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                Object result = methodProxy.invokeSuper(o,args);
                return result;

            }
        });

        //调用方法
        TestClass testClass = (TestClass) enhancer.create();
        testClass.test();

    }
}

package com.tl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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

    //主题
    interface Subject {
        void visit();
        void test();
    }

    //真实对象
    static class RealSubject implements Subject {
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

    //动态代理类
    static class DynamicProxy implements InvocationHandler {
        Subject subject;

        public DynamicProxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(subject, args);
        }

    }


}

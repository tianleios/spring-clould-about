package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    Object target;

    MyInvocationHandler(Object o) {

        this.target = o;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //可以在前面干些事情
        System.out.println("我要开始干坏事了");
        Object result =   method.invoke(target, args);
        System.out.println("我坏事做完了");
        //可以在后面干些事情

        return result;

    }

    public static void main(String[] args) {

        //被代理类, 一定要有被代理类实现了该方法
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        //拦截器 类
        InvocationHandler invocationHandler = new MyInvocationHandler(userServiceImpl);

        Class[] interfaces = new Class[]{IUserService.class};

        //动态创建出了  代理类
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        IUserService proxy = (IUserService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        //调用动态代理类的方法， 都会去调用 拦截器的 incoke 方法
        proxy.findUserNameById(1);
    }
}

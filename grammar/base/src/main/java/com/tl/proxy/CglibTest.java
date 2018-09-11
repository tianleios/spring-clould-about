package com.tl.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by tianlei on 2018/9/4
 */
public class CglibTest {


    static interface Subject {
        void eat();
    }

    static class Dog implements Subject {
        @Override
        public void eat() {
            System.out.println("eat");
        }
    }


    public static void main(String[] args) {

        {// 代理接口
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Subject.class);

            class DynamicProxy implements MethodInterceptor {

                Subject target;
                DynamicProxy(Subject t) {
                    this.target = t;
                }

                @Override
                public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                    System.out.println("eat before interface");
                    Object result = method.invoke(target, args);
                    System.out.println("eat after interface");
                    return result;
                }
            }

            Dog realSubject = new Dog();
            enhancer.setCallback(new DynamicProxy(realSubject));
            Subject subject = (Subject) enhancer.create();
            subject.eat();
        }

        {// 代理类
            // 相当于 动态代理中的 Proxy
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Dog.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                    System.out.println("eat before class");
                    Object result = methodProxy.invokeSuper(o, args);
                    System.out.println("eat after class");
                    return result;
                }
            });

            Dog dog = (Dog) enhancer.create();
            dog.eat();
        }

    }


}

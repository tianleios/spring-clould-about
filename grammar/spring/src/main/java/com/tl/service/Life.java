package com.tl.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
public class Life implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean , SmartInitializingSingleton{

    public Life() {
        System.out.println("我是构造函数");
    }

    @Resource
    User my;

//    @Autowired
//    BeanUser she;

    @Override
    public void setBeanName(String s) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }


    @Override
    public void destroy() throws Exception {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /******************************* beanPostProcessor  ***********************************/
    // 在自定义的 BeanPostProcessor 中，在当前类中应该不会返回当前类

    // 初始画好任何bean都会被调用
//    @Override
//    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
//        if (o instanceof User) {
//            System.out.println("********" + Thread.currentThread().getStackTrace()[1].getMethodName());
//        }
//        return o;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
//        if (o instanceof User) {
//            System.out.println("********"  + Thread.currentThread().getStackTrace()[1].getMethodName());
//        }
//        return o;
//    }

    /******************************* DIY  ***********************************/
    private void initMethod() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    private void destroyMethod() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /******************************* @  ***********************************/
    @PostConstruct
    public void postConstruct() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

//    @Override
//    public int getOrder() {
//        return 10;
//    }

    /****************************  SmartInitializingSingleton  ********************************/
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /******************************* lifeCyle  ***********************************/
    //




}

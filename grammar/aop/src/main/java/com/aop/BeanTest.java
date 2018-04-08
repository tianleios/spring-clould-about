package com.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanTest implements BeanNameAware, InitializingBean,BeanFactoryAware ,DisposableBean{


    @Override
    public void destroy() throws Exception {
        int a = 10;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        int a = 10;

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        int a = 10;
    }

    @Override
    public void setBeanName(String s) {
        int a = 10;
    }

    public String name;

    @PostConstruct
    public void post() {
        int a = 10;
    }

    @PreDestroy
    public void pre() {
        int b = 10;
    }

    private void beanTestInit() {

        int b = 10;
    }

    private void dest() {
        int b = 10;
    }
}

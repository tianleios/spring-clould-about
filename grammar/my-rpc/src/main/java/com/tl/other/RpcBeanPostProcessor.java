package com.tl.other;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * Created by tianlei on 2019/2/27
 */
@Component
public class RpcBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        for (Field field : bean.getClass().getDeclaredFields()) {
            if (null != field.getAnnotation(Rpc.class)) {
                Class cl = field.getType();
                if (cl.isInterface()) {
                    //首先要保证是一个接口
                  Object obj =  Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                          new Class[]{cl}, new RpcProxy());
                    field.setAccessible(true);
                    try {
                        field.set(bean, obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        return bean;
    }
}

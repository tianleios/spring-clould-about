package com.tl.diy.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Configuration
public class DIYBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Field[] fields = bean.getClass().getFields();

        for (Field field : fields) {
           DIY diy = field.getAnnotation(DIY.class);
           if (diy != null) {
               Class<? extends Field> aClass = field.getClass();
               try {
                   field.set(bean, aClass.newInstance());
               } catch (Exception e) {
               }
           }
        }
        return bean;
    }

}

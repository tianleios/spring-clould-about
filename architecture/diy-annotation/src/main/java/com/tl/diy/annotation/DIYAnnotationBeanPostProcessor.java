package com.tl.diy.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by tianlei on 2020/4/28
 */
@Component
public class DIYAnnotationBeanPostProcessor
        extends InstantiationAwareBeanPostProcessorAdapter
        implements MergedBeanDefinitionPostProcessor {

    private  Field diyField;

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {

        ReflectionUtils.doWithLocalFields(beanType, field -> {
            if (Modifier.isStatic(field.getModifiers())) {
                return;
            }
            DIY diy = field.getAnnotation(DIY.class);
            diyField = field;
        });

    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {

        if (diyField != null) {
            ReflectionUtils.makeAccessible(diyField);
            try {
                diyField.set(bean, new DIYClass("hahaha"));
            } catch (Exception e) {
            }

        }

        return pvs;
    }
}

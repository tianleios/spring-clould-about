package com.tl.config;

import org.activiti.bpmn.model.DataStore;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tianlei on 2018/9/13
 */
@Configuration
public class ActivitiConfig {


    @Bean
    public DataStore dataStore() {
        DataStore dataStore = new DataStore();
        return dataStore;
    }


    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration() {
        return new SpringProcessEngineConfiguration();
    }

    public static void main(String[] args) {
        System.out.print(10);
    }

}

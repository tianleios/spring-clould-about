package com.tlstarter.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tianlei on 2020/1/17
 */
@Configuration
public class TLConfiguration {

    @Bean
    public TLMsgSender tlMsgSender() {
        return new TLMsgSender();
    }

}

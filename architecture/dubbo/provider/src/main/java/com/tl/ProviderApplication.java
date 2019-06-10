package com.tl;

import com.tl.common.action.TccActionTwo;
import io.seata.spring.annotation.GlobalTransactionScanner;
import com.tl.common.action.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author tianlei
 * @date 2019/05/22
 */
@SpringBootApplication
@EnableDubbo
public class ProviderApplication {


    @Bean
    GlobalTransactionScanner globalTransactionScanner() {
        GlobalTransactionScanner globalTransactionScanner =
            new GlobalTransactionScanner("tcc-sample","my_test_tx_group");
        return globalTransactionScanner;
    }


    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class);
    }
}

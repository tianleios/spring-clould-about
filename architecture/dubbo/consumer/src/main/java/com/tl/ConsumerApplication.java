package com.tl;

import com.tl.service.TccTransactionService;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfigBinding;
import com.tl.common.action.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tianlei
 * @date 2019/05/18
 */
@SpringBootApplication
@RestController
@EnableDubbo
public class ConsumerApplication   {

    //@Resource
    //private TccTransactionService tccTransactionService;
    ////
    //@GetMapping("/test")
    //public void test() {
    //    dubboService.find();
    //    tccTransactionService.doTransactionCommit();
    //}

    //@Bean
    //GlobalTransactionScanner globalTransactionScanner() {
    //    GlobalTransactionScanner globalTransactionScanner =
    //        new GlobalTransactionScanner("tcc-sample","my_test_tx_group");
    //    return globalTransactionScanner;
    //}


    @Reference(url = "dubbo://localhost:20880")
    DubboService dubboService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }

}

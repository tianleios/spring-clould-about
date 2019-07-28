package com.tl.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tianlei
 * @date 2019/05/27
 */
@SpringBootApplication
public class SentinelApplication {


    public static void main(String[] args) {

        SpringApplication.run(SentinelApplication.class);

    }


    public void test() {
        Entry entry = null;
        try {
            entry = SphU.entry("resourceName");

        } catch (BlockException e) {

        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }
}

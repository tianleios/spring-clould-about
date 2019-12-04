package com.tl.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author tianlei
 * @date 2019/05/27
 */
@SpringBootApplication
public class SentinelApplication {

    private static String KEY = "R";

    public static void main(String[] args) {

        for (int i = 0; i < 100 ; i ++) {
            String key = Integer.valueOf(i).toString();
            initRule(key);
            test(key);
        }

//        SpringApplication.run(SentinelApplication.class);

    }

    public static void initRule(String key) {
        FlowRule flowRule = new FlowRule();
        flowRule.setCount(1);
        flowRule.setControlBehavior(0);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setLimitApp("default");
        flowRule.setResource(key);
        FlowRuleManager.loadRules(Arrays.asList(flowRule));
    }

    public static void test(String key) {
        Entry entry = null;
        try {
            entry = SphU.entry(key);

        } catch (BlockException e) {
             System.out.println("被限流了" + key);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }
}

package com.tl.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.Arrays;

/**
 * Created by tianlei on 2020/3/16
 */
public class FlowControlTest {

    private static String KEY = "R";

    /**
     * https://github.com/alibaba/Sentinel/wiki/%E6%B5%81%E9%87%8F%E6%8E%A7%E5%88%B6
     *
     */
    public static void main(String[] args) {

        System.out.println("开始");
        initRule(KEY);
        for (int i = 0; i < 100 ; i ++) {
            System.out.println(i);
            test(KEY);
        }

    }

    public static void initRule(String key) {
        FlowRule flowRule = new FlowRule();
        flowRule.setCount(1);

        /**
         *     CONTROL_BEHAVIOR_DEFAULT = 0;  直接拒绝
         *     CONTROL_BEHAVIOR_WARM_UP = 1;  预热
         *     CONTROL_BEHAVIOR_RATE_LIMITER = 2; 匀速排队，漏桶算法
         *     CONTROL_BEHAVIOR_WARM_UP_RATE_LIMITER = 3;  没找到
         */
        flowRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);

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

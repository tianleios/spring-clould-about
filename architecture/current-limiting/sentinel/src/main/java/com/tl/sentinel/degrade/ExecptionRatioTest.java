package com.tl.sentinel.degrade;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by tianlei on 2020/3/16
 */
public class ExecptionRatioTest {

    /**
     * https://github.com/alibaba/Sentinel/wiki/%E6%B5%81%E9%87%8F%E6%8E%A7%E5%88%B6
     *
     */
    public static void main(String[] args) throws Exception {

        String key = "degrade";

        System.out.println("开始");
        initRule(key);

        for (int i = 0; i < 500 ; i ++) {
            System.out.println(i);
            test(key, i);
        }

    }

    public static void initRule(String key) {
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource(key);
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_RATIO);
        // 异常比例
        degradeRule.setCount(0.2);
        degradeRule.setTimeWindow(1);
        degradeRule.setLimitApp("default");
        DegradeRuleManager.loadRules(Arrays.asList(degradeRule));
    }

    private static void test(String key, int i) {
        Entry entry = null;
        try {

            TimeUnit.MILLISECONDS.sleep(5);
            entry = SphU.entry(key, EntryType.IN);

            System.out.println("pass " + i);
            // Write your biz code here.
            // <<BIZ CODE>>

            throw new RuntimeException("业务异常");

        } catch (Throwable t) {
            if (BlockException.isBlockException(t)) {

                System.out.println("降级了");

            } else {
                System.out.println(t);
                Tracer.trace(t);
            }
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }
}

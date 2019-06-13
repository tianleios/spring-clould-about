package com.tl.sc.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.tl.sc.common.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianlei
 * @date 2019/06/09
 */
@RestController
public class TestController {

    private static final String R_NAME = "test";

    @Autowired
    UserApi userApi;

    @GetMapping("/test")
    public String test() {
        return userApi.getUserName(1L);
    }

    @GetMapping("/sentinel")
    @SentinelResource(value = R_NAME, blockHandler = "blockHandler", fallback = "fallback")
    public String sentinel()  {

        if (1 > 0) {
            throw new RuntimeException();
        }
        return "success";
    }

    @PostConstruct
    public void init() {
        initFlowRules();
    }

    private void initFlowRules() {

        {
            // 限流模式
            //List<FlowRule> rules = new ArrayList<>();
            //FlowRule rule = new FlowRule();
            //rule.setResource(R_NAME);
            //rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
            //rule.setCount(1);
            //rules.add(rule);
            //FlowRuleManager.loadRules(rules);

        }

        {
            //降级模式
            List<DegradeRule> rules = new ArrayList<>();
            DegradeRule rule = new DegradeRule();
            rule.setResource(R_NAME);
            // set threshold rt, 10 ms
            rule.setCount(1);
            rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
            rule.setTimeWindow(10);
            rules.add(rule);
            DegradeRuleManager.loadRules(rules);
        }
    }

    // 注意参数类型
    public String blockHandler(BlockException e) {
        System.out.println("handler" + e);
        return "blockHandler";
    }

    //
    public String fallback(DegradeException dExecption) {

        System.out.println("fallback");
        return "fallback";
    }

}

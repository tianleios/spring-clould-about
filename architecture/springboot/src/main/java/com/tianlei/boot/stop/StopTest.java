package com.tianlei.boot.stop;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by tianlei on 2020/4/1
 */
@Component
public class StopTest {

//    https://mp.weixin.qq.com/s/UVSnl_wuS-31hn0qaPaqlg
    //  结束时会调用该方法
    //  curl -X POST  http://localhost:3333/actuator/shutdown  请求
    @PreDestroy
    private void destroy() {
        int a = 10;
    }
}

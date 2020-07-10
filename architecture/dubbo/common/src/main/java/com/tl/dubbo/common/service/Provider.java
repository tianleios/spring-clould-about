package com.tl.dubbo.common.service;

import com.tl.dubbo.common.model.Teacher;

/**
 * Created by tianlei on 2019-07-28
 */
public interface Provider {

    Teacher sayHi(String content, int a);

    String test();


}

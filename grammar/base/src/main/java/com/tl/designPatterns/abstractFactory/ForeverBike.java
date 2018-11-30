package com.tl.designPatterns.abstractFactory;

import com.tl.designPatterns.abstractFactory.base.AbstractBike;

/**
 * Created by tianlei on 2018/9/13
 */
public class ForeverBike extends AbstractBike {
    @Override
    public void show() {
        System.out.println("永久一辆");
    }
}

package com.tl.designPatterns.abstractFactory;

import com.tl.designPatterns.abstractFactory.base.AbstractCar;

/**
 * Created by tianlei on 2018/9/13
 */
public class BMCar extends AbstractCar {
    @Override
    public void show() {
        System.out.println("宝马一辆");
    }
}

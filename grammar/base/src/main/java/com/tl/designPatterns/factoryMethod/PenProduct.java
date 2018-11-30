package com.tl.designPatterns.factoryMethod;

import com.tl.designPatterns.factoryMethod.base.Product;

/**
 * Created by tianlei on 2018/9/13
 */
public class PenProduct extends Product {
    @Override
    public void show() {
        System.out.println("我是钢笔");
    }
}

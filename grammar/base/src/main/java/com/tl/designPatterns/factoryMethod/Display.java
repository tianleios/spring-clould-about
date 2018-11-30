package com.tl.designPatterns.factoryMethod;

/**
 * Created by tianlei on 2018/9/13
 */
public class Display {

    // 工厂方法
    public static void main(String[] args) {

        // 可以创键不同的产品，和相应的工厂
        new PenFactory().create().show();

    }
}

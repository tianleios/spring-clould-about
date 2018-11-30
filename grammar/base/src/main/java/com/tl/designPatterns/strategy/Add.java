package com.tl.designPatterns.strategy;

/**
 * Created by tianlei on 2018/9/13
 */
public class Add implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

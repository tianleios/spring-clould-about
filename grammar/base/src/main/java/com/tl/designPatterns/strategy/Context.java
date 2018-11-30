package com.tl.designPatterns.strategy;

/**
 * Created by tianlei on 2018/9/13
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

    public static void main(String[] args) {

        // 策略模式， 把算法封装成对象
        System.out.println(new Context(new Add()).execute(1, 1));
        System.out.println(new Context(new Substract()).execute(1, 1));


    }

}

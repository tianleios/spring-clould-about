package com.tl.designPatterns.singleton;

/**
 * Created by tianlei on 2019/1/5
 */
public class Singleton01 {

    private static Singleton01 singleton01;

    static {
        singleton01 = new Singleton01();
    }

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        return singleton01;
    }

}

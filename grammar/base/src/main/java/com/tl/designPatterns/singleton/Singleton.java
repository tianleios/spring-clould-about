package com.tl.designPatterns.singleton;

/**
 * Created by tianlei on 2019/1/5
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }

}

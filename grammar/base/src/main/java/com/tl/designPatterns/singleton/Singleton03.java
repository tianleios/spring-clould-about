package com.tl.designPatterns.singleton;

/**
 * Created by tianlei on 2019/1/5
 */
public class Singleton03 {

    private static volatile Singleton03 instance;

    private Singleton03() {

    }

    public static Singleton03 getInstance() {
        if (instance == null) {
            synchronized (Singleton03.class) {
                if (instance == null) {
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }
}

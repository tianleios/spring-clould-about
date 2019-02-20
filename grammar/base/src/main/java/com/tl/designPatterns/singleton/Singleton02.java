package com.tl.designPatterns.singleton;

/**
 * Created by tianlei on 2019/1/5
 */
public class Singleton02 {

    private static class Holder {
        private static Holder instance = new Holder();
    }

    public static Holder getInstance() {
        return Holder.instance;
    }

}

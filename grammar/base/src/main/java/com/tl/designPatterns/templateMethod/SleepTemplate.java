package com.tl.designPatterns.templateMethod;

/**
 * Created by tianlei on 2018/9/13
 */
public abstract class SleepTemplate {

    public void dream() {
        this.before();
        this.doing();
        this.after();
    }

    protected abstract void before();
    protected abstract void doing();
    protected abstract void after();

}

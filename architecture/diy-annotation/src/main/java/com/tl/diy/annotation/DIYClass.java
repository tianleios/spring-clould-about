package com.tl.diy.annotation;

/**
 * Created by tianlei on 2020/4/28
 */
public class DIYClass {

    public DIYClass(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

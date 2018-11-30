package com.tl.designPatterns.templateMethod;

/**
 * Created by tianlei on 2018/9/13
 */
public class MySleepTemplate extends SleepTemplate {

    @Override
    protected void before() {
        System.out.println("洗澡、刷牙");
    }

    @Override
    protected void doing() {
        System.out.println("中国梦🇨🇳");
    }

    @Override
    protected void after() {
        System.out.println("刷牙、洗脸");
    }

    public static void main(String[] args) {

        MySleepTemplate template = new MySleepTemplate();
        template.dream();

    }

}

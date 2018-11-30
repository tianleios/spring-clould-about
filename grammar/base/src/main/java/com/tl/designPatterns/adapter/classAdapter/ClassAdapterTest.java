package com.tl.designPatterns.adapter.classAdapter;

/**
 * Created by tianlei on 2018/11/7
 */
public class ClassAdapterTest {

    public static void main(String[] args) {

        //类设计模式，基于继承

        //PrintBanner - adapter
        //Banner - adaptee
        //Print 需求
        PrintBannerAdapter printBanner = new PrintBannerAdapter("hello");
        printBanner.printWeak();
        printBanner.printStrong();
    }

    // 需求
    public interface Print {
        void printWeak();
        void printStrong();

    }

    //适配器
    public static class PrintBannerAdapter extends Banner implements Print {

        public PrintBannerAdapter(String str) {
            super(str);
        }

        @Override
        public void printWeak() {
            this.showWithParen();
        }

        @Override
        public void printStrong() {
            this.showWithAster();
        }
    }

    // 适配源
    public static class Banner {

        private String str;

        public Banner(String str) {
            this.str = str;
        }

        public void showWithParen() {
            System.out.println("(" + str + ")");
        }

        public void showWithAster() {
            System.out.println("*" + str + "*");
        }
    }



}

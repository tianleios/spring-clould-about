package com.tl.designPatterns.adapter.classAdapter;

/**
 * Created by tianlei on 2018/11/7
 */
public class ObjAdapterTest {

    public static void main(String[] args) {

        //基于委托设计模式

        //PrintBanner - adapter
        //Banner - adaptee
        //Print 需求
        PrintBannerAdapter adapter = new PrintBannerAdapter("hello");
        adapter.printWeek();
        adapter.printStrong();

    }

    public static abstract class Print {
        public abstract void printWeek();
        public abstract void printStrong();
    }

    public static  class PrintBannerAdapter extends Print {

        Banner banner;
        public PrintBannerAdapter(String str) {
            this.banner = new Banner(str);
        }

        @Override
        public void printWeek() {
            this.banner.showWithParen();
        }

        @Override
        public void printStrong() {
            this.banner.showWithAster();
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

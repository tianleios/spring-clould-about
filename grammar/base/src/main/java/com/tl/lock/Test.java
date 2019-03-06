package com.tl.lock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tianlei on 2018/11/28
 */
public class Test {



    public static void main(String... args) throws InterruptedException {
//        final byte[] lock = new byte[0];
//
//        final Thread thread1 = new Thread("thread1") {
//            @Override
//            public void run() {
//                System.out.println("thread1 is ready!");
//                try {
//                    Thread.sleep(1000 * 5);
//                } catch (InterruptedException e) {
//                }
//
//                synchronized (lock) {
//                    lock.notify();
//                    System.out.println("thread1 is notify, but not exit synchronized!");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                    }
//                    System.out.println("thread1 is exit synchronized!");
//                }
//            }
//        };
//
//        final Thread thread2 = new Thread("thread2") {
//            @Override
//            public void run() {
//                System.out.println("thread2 is ready!");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                }
//
//                synchronized (lock) {
//                    try {
//                        System.out.println("thread2 is waiting!");
//                        lock.wait();
//                        System.out.println("thread2 is awake!");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//
//        thread1.start();
//        thread2.start();

        System.out.println(re());
    }



    public static String re() {
        String x = "0";
        try {
            return x;
        } finally {
//            System.out.println("2x");
            x = "1";
        }
    }




    public Test(int a) {


        List<String> arr = new ArrayList<>();

        Iterator<String> it = arr.iterator();

        it.remove();

    }



}

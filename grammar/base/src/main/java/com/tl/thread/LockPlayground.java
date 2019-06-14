package com.tl.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPlayground {


    private Lock lock = new ReentrantLock();


    public void test() {
        //获取锁
        lock.lock();

        //解锁
        lock.unlock();

        if (lock.tryLock()) {
            // 获取 锁 成功

        } else {
            // 获取 锁 失败

        }


    }


    public static void main(String[] args) throws Exception {

        Object obj1 = new Object();
        Object obj2 = new Object();


        Thread.sleep(100000);



        new Thread(() -> {
            synchronized (obj1) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }).start();

//        new Thread(() -> {
//            synchronized (obj2) {
//                synchronized (obj1) {
//
//                }
//            }
//        }).start();

    }

}

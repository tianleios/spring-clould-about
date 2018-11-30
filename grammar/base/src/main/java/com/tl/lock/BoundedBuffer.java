package com.tl.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianlei on 2018/10/28
 */
public class BoundedBuffer {

    // 支持 put 和 take 两个操作，
    // put 如果已满，等待有空间
    // take 取时 如果为空，等待有可取元素
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        System.out.println("put lock");
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putptr] = x;
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
            System.out.println("put unlock");
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        System.out.println("take lock");
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
            System.out.println("take unlock");

        }
    }


    public static void main(String[] args) throws Exception {


        Lock lock = new ReentrantLock();

//        new Thread(() -> {
//            try {
//
//
//                System.out.println("1");
//                lock.lock();
//                System.out.println("11");
//            } finally {
//                lock.unlock();
//            }
//
//        }).start();
//
//        new Thread(() -> {
//            System.out.println("2");
//
//            lock.lock();
//            System.out.println("22");
//
//
//        }).start();



        BoundedBuffer boundedBuffer = new BoundedBuffer();


        new Thread(() -> {

            try {
                System.out.println("1" + Thread.currentThread().getName());
                boundedBuffer.take();
                System.out.println("1 end");

            } catch (Exception e) {

            }

        }).start();

        new Thread(() -> {

            try {
                System.out.println("2" + Thread.currentThread().getName());
                boundedBuffer.put(1);
                System.out.println("2 end");

            } catch (Exception e) {

            }

        }).start();


    }

}

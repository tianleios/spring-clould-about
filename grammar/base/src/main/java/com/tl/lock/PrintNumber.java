package com.tl.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianlei on 2018/10/5
 */
public class PrintNumber {


    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile int a = 0;

    public static int number = 0;


    public static void main(String[] args) {

        print();

//        testIntterpt();

//        lastVersion();


    }

    /**
     * 交替打印奇偶数
     */
    public void printA() {
        Thread t1 = new Thread(() -> {

            lock.lock();
            try {
                while (a < 10) {
                    condition.await();
                    System.out.println(Thread.currentThread().getName() + "-" + (a++));
                    condition.signal();
                }
            } catch (InterruptedException e) {
            }

            lock.unlock();


        });

        Thread t2 = new Thread(() -> {

            lock.lock();
            try {
                while (a < 11) {
                    condition.signal();
                    System.out.println(Thread.currentThread().getName() + "-" + (a++));
                    condition.await();
                }
            } catch (InterruptedException e) {

            }
            lock.unlock();
        });

        t1.start();
        t2.start();
    }

    /**
     * 由A线程先打印1，2，3，然后由B线程打印4,5,6，然后再由A线程打印7，8，9
     */
    public static void printB() {


        new Thread(() -> {

            try {
                lock.lock();
                condition.await();
                while (true) {
                    System.out.println("B" + number++);
                    if (number == 6) {
                        condition.signal();
                        break;
                    }
                }
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }

        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                while (true) {
                    System.out.println("A" + number++);
                    if (number == 3) {
                        condition.signal();
                        condition.await();
                    }

                    if (number == 9) {
                        break;
                    }
                }

            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
        }).start();


    }


    //***************************************************** 另外一种实现方式 ************************************************//
    public static void print() {

        Object lock = new Object();
        int num = 5;

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (lock) {
                        System.out.println("a");
                        lock.notify();
                        lock.wait();

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (lock) {
                        System.out.println("b");
                        lock.notify();
                        lock.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }

    public static void testIntterpt() {

        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t1.interrupt();
    }


    //*****************************************************  感觉是最合理的  ************************************************//
    private static Condition oddCondition = lock.newCondition();
    private static Condition evenCondition = lock.newCondition();

    public static void lastVersion() {

        new Thread(() -> {

            lock.lock();
            while (a < 10) {

                System.out.println("a" + a++);
                oddCondition.signal();
                try {
                    evenCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

            lock.unlock();

        }).start();


        new Thread(() -> {

            lock.lock();
            while (a < 10) {

                System.out.println("b" + a++);
                evenCondition.signal();
                try {
                    oddCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }).start();

    }
}

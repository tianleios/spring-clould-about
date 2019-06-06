package com.tl.lock.printNumber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tianlei
 * @date 2019/05/17
 */
public class Print {


    public static ReentrantLock lock =  new ReentrantLock();

    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();
    public static Condition conditionC = lock.newCondition();


    public static void main(String[] args) {

        new Thread(() -> {

            lock.lock();
            try {

                while (true) {
                    try {
                        System.out.println("A");

                        conditionB.signal();
                        conditionA.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {

            lock.lock();
            try {

                while (true) {

                    try {
                        System.out.println("B");
                        conditionC.signal();
                        conditionB.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {

            lock.lock();
            try {
                while (true) {

                    try {
                        System.out.println("C");

                        conditionA.signal();
                        conditionC.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            } finally {
                lock.unlock();
            }
        }).start();
    }
}

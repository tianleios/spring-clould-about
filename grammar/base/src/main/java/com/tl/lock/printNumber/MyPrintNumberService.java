package com.tl.lock.printNumber;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianlei on 2018/12/15
 */
public class MyPrintNumberService {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean tag = false;

    public void set() {
        try {
            lock.lock();
            while (tag == false) {
                System.out.println("A");
            }
            tag = true;
        } finally {
            lock.unlock();
        }
    }


    public void get() {
        try {
            lock.lock();

            while (tag == true) {
                System.out.println("B");
            }
            tag = false;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        MyPrintNumberService printNumberService = new MyPrintNumberService();

        new Thread(() -> {

            for (int i = 0 ; i < 10 ; i ++) {
                printNumberService.set();
            }

        }).start();

        new Thread(() -> {
            for (int i = 0 ; i < 10 ; i ++) {
                printNumberService.get();
            }
        }).start();

    }

    @Test
    public void t() {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        reentrantLock.lock();
        condition.signalAll();
        reentrantLock.unlock();
    }

}

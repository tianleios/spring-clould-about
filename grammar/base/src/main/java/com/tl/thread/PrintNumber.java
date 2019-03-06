package com.tl.thread;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tianlei on 2019/2/22
 */
public class PrintNumber {



    int i = 0;



    @Test
    public void test() {

         ReentrantLock reentrantLock = new ReentrantLock();
         Condition conA = reentrantLock.newCondition();
         Condition conB = reentrantLock.newCondition();
         Condition conC = reentrantLock.newCondition();


        new Thread(() -> {

            reentrantLock.lock();
            for (;i < 100;) {
                System.out.println("A" + (i ++));
                conB.signal();
                try {
                    conA.await();
                } catch (InterruptedException e) {

                }
            }


        }).start();

        new Thread(() -> {

            reentrantLock.lock();
            for (;i < 100;) {
                System.out.println("B" + (i ++));
                conC.signal();
                try {
                    conB.await();
                } catch (InterruptedException e) {

                }
            }


        }).start();

        new Thread(() -> {

            reentrantLock.lock();
            for (;i < 100;) {
                System.out.println("C" + (i ++));
                conA.signal();
                try {
                    conC.await();
                } catch (InterruptedException e) {

                }
            }


        }).start();

    }


    /**
     * 这种方式不行
     */
    @Test
    public void testSemphore() {

        Semaphore semaphore = new Semaphore(1, true);

        new Thread(() -> {

            for (;i < 100;) {
                try {
                    semaphore.acquire();
                    System.out.println("A" + (i ++));
                    semaphore.release();
                } catch (InterruptedException e) {

                }
            }


        }).start();

        new Thread(() -> {

            for (;i < 100;) {
                try {
                    semaphore.acquire();
                    System.out.println("B" + (i ++));
                    semaphore.release();
                } catch (InterruptedException e) {

                }
            }


        }).start();

        new Thread(() -> {

            for (;i < 100;) {
                try {
                    semaphore.acquire();
                    System.out.println("C" + (i ++));
                    semaphore.release();
                } catch (InterruptedException e) {

                }
            }


        }).start();

    }


}

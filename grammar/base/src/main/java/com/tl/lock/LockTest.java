package com.tl.lock;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by tianlei on 2018/9/30
 */
public class LockTest {


    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    static ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) throws Exception {

//        LongAccumulator l = new LongAccumulator((left, right) -> {
//            return left * right;
//        }, 1);
//        l.accumulate(2);
//        l.accumulate(3);
//        l.accumulate(4);
//        System.out.println(l.get());

//        countDownLatch();
//        cyclicBarrier();
//        semaphore();
//        deadLock();
        reentrantLockTest();
//        readWriteLock();
//        lockCondition();


    }

    public static class Test {

        public int count = 0;

        public void inc() {
            count++;
        }

    }

    //读写锁
    public static void readWriteLock() {

        //读锁获取，其它线程没有写锁
        //写锁获取，其它线程没有写锁 and 读锁

        // writeLock 可以降级为 readLock , 反过来升级是不可能的


        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        new Thread(() -> {
            lock.readLock().lock();
            lock.writeLock().lock();
            lock.readLock().unlock();

        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }


//        new Thread(() -> {
//            lock.writeLock().lock();
//            try {
//                System.out.println("1 begin");
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("1 end");
//            } catch (InterruptedException e) {
//
//            } finally {
//                lock.writeLock().unlock();
//            }
//
//        }).start();

        new Thread(() -> {

            try {
                lock.readLock().lock();
                System.out.println("2");
            } finally {
                lock.readLock().unlock();
            }

        }).start();

        new Thread(() -> {

            try {
                if (lock.writeLock().tryLock(2, TimeUnit.SECONDS)) {

                    lock.writeLock().lock();
                    System.out.println("3");

                } else {
                    System.out.println("3 失败");

                }

            } catch (InterruptedException e) {

            }

        }).start();


    }


    public static void lockCondition() {

        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {

            try {

                reentrantLock.lock();
                System.out.println("1 begin");
                condition.await();
                System.out.println("1 end");
                reentrantLock.unlock();


            } catch (InterruptedException e) {

            } finally {
            }

        }).start();

        sleep();

        new Thread(() -> {

            reentrantLock.lock();
            System.out.println("2 begin");
            sleep();
            condition.signal();
            System.out.println("2 end");
            reentrantLock.unlock();


        }).start();


    }

    public static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        } finally {
        }
    }


    public static void reentrantLockTest() throws Exception {


        new Thread(() -> {

            try {

                // 获取第一次锁
                reentrantLock.lock();
                System.out.println("1 begin");
                TimeUnit.SECONDS.sleep(5);

                // 获取第二次锁，holdCount 为2，需要释放2次
                reentrantLock.lock();
                System.out.println("1 end");

            } catch (InterruptedException e) {

            } finally {
                reentrantLock.unlock();
            }

        }).start();


        new Thread(() -> {
            try {

                if (reentrantLock.tryLock(8, TimeUnit.SECONDS)) {

                    reentrantLock.lock();
                    System.out.println("2 begin");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("2 end");

                } else {
                    System.out.println("2 - 获取锁失败");
                }

            } catch (InterruptedException e) {

            } finally {
                reentrantLock.unlock();
            }

        }).start();


    }


    public static void semaphore() throws Exception {
        Semaphore semaphore = new Semaphore(1);
        int a = 0;

        new Thread(() -> {
            try {
                // 获得信号
                semaphore.acquire();
                System.out.println("1");
                Thread.sleep(3000);
                //释放信号
                semaphore.release();
                System.out.println("1 done");
            } catch (Exception e) {

            }
        }).start();

        new Thread(() -> {
            try {
                //获得信号
                semaphore.acquire();

                System.out.println("2");

                semaphore.release();

            } catch (Exception e) {

            }
        }).start();

    }


    public static void cyclicBarrier() throws Exception {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("已经积攒了2个线程，开始执行任务");
        });

        // 到齐发车
        new Thread(() -> {
            try {
                System.out.println("1 开始执行");
                Thread.sleep(2000);
                cyclicBarrier.await();
                System.out.println("1 执行完毕");
            } catch (Exception e) {

            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("2 开始执行");
                Thread.sleep(2000);
                cyclicBarrier.await();
                System.out.println("2 执行完毕");
            } catch (Exception e) {

            }
        }).start();

    }


    public static void countDownLatch() throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                System.out.println("1 开始执行");
                Thread.sleep(2000);
                countDownLatch.countDown();
            } catch (Exception e) {

            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("2 开始执行");
                Thread.sleep(2000);
                countDownLatch.countDown();
            } catch (Exception e) {

            }
        }).start();

        System.out.println("执行");
        countDownLatch.await();
        System.out.println("执行完毕");

    }


    public static void deadLock() {

        new Thread(() -> {

            synchronized (obj1) {

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {

                }
                synchronized (obj2) {

                }
            }

        }).start();

        new Thread(() -> {

            synchronized (obj2) {

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {

                }
                synchronized (obj1) {

                }
            }

        }).start();
    }


    @org.junit.Test
    public void exchanger() {

        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                String exchangeName = exchanger.exchange(name);
                System.out.println(name + "-" + exchangeName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                System.out.println("睡觉前");
//                Thread.sleep(100);
                System.out.println("睡觉后");
                String exchangeName = exchanger.exchange(name);
                System.out.println(name + "-" + exchangeName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }


    @org.junit.Test
    public void lockSupport() {

        Thread t = new Thread(() -> {
            System.out.println("before");
            LockSupport.park();
            System.out.println("after");
        });

        t.start();
        try {
            System.out.println("sleep - before");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("sleep - after");
        } catch (Exception e) {
        }
        LockSupport.unpark(t);
    }

    @org.junit.Test
    public void testAQS() {

        reentrantLock.lock();

        new Thread(() -> {
            reentrantLock.lock();
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//            }
            reentrantLock.lock();

        }).start();
    }


}

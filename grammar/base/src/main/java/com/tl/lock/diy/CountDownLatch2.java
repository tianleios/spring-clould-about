package com.tl.lock.diy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by tianlei on 2018/11/9
 */
public class CountDownLatch2 {


    /**
     * 共享实现方式
     */

    private Sync sync;

    public CountDownLatch2(int count) {
        this.sync = new Sync(count);

    }

    private static final class Sync extends AbstractQueuedSynchronizer {

        public Sync(int count) {
            this.setState(count);
        }


        /**
         * 尝试获取资源
         * 如果返返回值>=0，则说明同步状态(state)有剩余，获取锁成功直接返回
         * 返回值<0，说明获取同步状态失败
         * @param arg
         * @return
         */
        @Override
        protected int tryAcquireShared(int arg) {
            return getState() == 0 ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {

            int state = this.getState();
            if (state == 0) {
                return false;
            } else {
                for (;;) {
                    int nextState = state - arg;
                    if (this.compareAndSetState(state, nextState)) {
                        return nextState == 0;
                    }
                }
            }
        }
    }


    public void countDown() {
        this.sync.releaseShared(1);
    }


    public void await() throws InterruptedException {
        this.sync.acquireSharedInterruptibly(1);
    }


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch2 countDownLatch = new CountDownLatch2(2);

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("1 complection");
                countDownLatch.countDown();
            } catch (Exception e) {

            }
        }).start();

        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("2 complection");
                countDownLatch.countDown();
            } catch (Exception e) {

            }
        }).start();

        countDownLatch.await();
        System.out.println("all");


    }


}

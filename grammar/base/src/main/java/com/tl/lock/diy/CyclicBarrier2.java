package com.tl.lock.diy;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by tianlei on 2018/11/12
 */
public class CyclicBarrier2 {

    final private int parties;
    private Runnable task;
    private Sync sync;
    private boolean isExecute  = false;

    public CyclicBarrier2(int parties, Runnable task) {
        this.parties = parties;
        this.task = task;
        this.sync = new Sync(parties, this);
        executeTask();
    }

    public void executeTask() {
        if (!isExecute) {
            isExecute = true;
            new Thread(() -> {
                task.run();
            }).start();
        }

    }

    private static class Sync extends AbstractQueuedSynchronizer {

        private int parties;
        private CyclicBarrier2 master;

        public Sync(int parties, CyclicBarrier2 master) {
            this.setState(parties);
            this.parties = parties;
            this.master = master;
        }

        private int getLastState() {
            return this.getState();
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (; ; ) {
                int currentStatus = this.getState();
                if (currentStatus == 0) {
                    return 0;
                } else {
                    int next = currentStatus - 1;
                    if (this.compareAndSetState(currentStatus, next)) {
                        if (next == 0) {
                            this.master.executeTask();
                        }
                        return next;
                    } else {
                        return -1;
                    }

                }
            }
        }

    }

    public void await() {

        this.sync.acquireShared(1);

    }

    public static void main(String[] args) {

        CyclicBarrier2 cyclicBarrier = new CyclicBarrier2(2, () -> {
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

}

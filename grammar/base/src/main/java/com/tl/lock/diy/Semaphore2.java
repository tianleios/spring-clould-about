package com.tl.lock.diy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by tianlei on 2018/11/9
 */
public class Semaphore2 {

    private Sync sync;

    private static class Sync extends AbstractQueuedSynchronizer {

        public Sync(int permists) {
            this.setState(permists);
        }

        // -1 0 1
//         如果返返回值>=0，则说明同步状态(state)有剩余，获取锁成功直接返回
//         返回值<0，说明获取同步状态失败
        @Override
        protected int tryAcquireShared(int arg) {
            for (;;) {
                int state = this.getState();
                if (state == 0) {
                    return -1;
                }
                if (this.compareAndSetState(state, state - 1)) {
                    return state - 1;
                }
            }
        }

        // -1 0 1
        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int state = this.getState();
                if (this.compareAndSetState(state, state + 1)) {
                    return true;
                }
            }
        }

    }


    public Semaphore2(int permists) {
        this.sync = new Sync(permists);
    }

    public void acquire() {
        this.sync.acquireShared(1);
    }

    public void release() {
        this.sync.releaseShared(1);
    }


    public static void main(String[] args) {

        Semaphore2 semaphore2 = new Semaphore2(1);

        new Thread(() -> {
            semaphore2.acquire();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
            }
            System.out.println("1");
            semaphore2.release();
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            semaphore2.acquire();
            System.out.println("2");
            semaphore2.release();
        }).start();


    }

}

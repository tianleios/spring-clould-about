package com.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pool {

    public static void main(String[] args) {

        Executors.newFixedThreadPool(1); //创建指定线程
        Executors.newCachedThreadPool(); //没有线程，就会创建线程，默认线程缓存60s, 容易OOM
        Executors.newSingleThreadExecutor(); //创建一个线程执行任务，如果线程异常技术，那么就会创建新的线程，这个，保证任务的串行执行

        //指定线程数量为3, 任务10天执行一次
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(() -> {

        },10, TimeUnit.DAYS);



    }
}

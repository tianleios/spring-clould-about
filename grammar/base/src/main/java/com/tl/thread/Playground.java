package com.thread;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Playground {

    public static void main(String[] args) {



        Thread.currentThread().setName("currentThread");
        System.out.println(Thread.currentThread().getName());

        //
        Thread thread = new Thread(){

            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName());
            }

        };
        thread.setPriority(1);
        thread.setName("thread1");

        //
        Runnable runnable = () -> {

            System.out.println(Thread.currentThread().getName());

        };
        Thread thread2 = new Thread(runnable);
        thread2.setPriority(10);
        thread2.setName("thread2");

        // 由于线程2 优先级较高，会出现问题
        thread.start();
        thread2.start();

        //
        FutureTask<Integer> futureTask = new FutureTask(() -> {

            System.out.println(Thread.currentThread().getName());
            return 5;

        });

        Thread thread3 = new Thread(futureTask);
        thread3.setName("thread3");
        thread3.start();
        try {

            //t同步方法会阻塞当前线程
            Integer result = futureTask.get();

            int a = 10;
        } catch (Exception e) {

        }

        //线程池
        ExecutorService executors =  Executors.newCachedThreadPool();
        //加入到线程池 中，就会在核实的时候执行
        executors.submit(() -> {

            System.out.println(Thread.currentThread().getName());

        });




    }





}

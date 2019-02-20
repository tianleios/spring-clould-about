package com.tl.thread;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by tianlei on 2018/12/13
 */
public class ExectorTest {


    @Test
    public void test() {

        Executor executor = null;
        try {
            executor = Executors.newFixedThreadPool(2);
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                throw new RuntimeException("error");
            });
        } catch (Exception e) {
            System.out.println(" !! ");
            e.printStackTrace();
        }


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }

        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            sleep();
        });

        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            sleep();
        });
    }

    public void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
    }

    @Test
    public void testSchedule() {

       ScheduledExecutorService sc = Executors.newScheduledThreadPool(2);
       sc.scheduleAtFixedRate(() -> {

           System.out.println("任务执行" + Thread.currentThread().getName());
//           throw new RuntimeException("self error");

       },0,1, TimeUnit.SECONDS);

       try {
           TimeUnit.SECONDS.sleep(10);
       } catch (Exception e) {

       }
    }
}

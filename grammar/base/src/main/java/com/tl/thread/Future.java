package com.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Future {


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {

        Future futureqq = new Future();

        futureqq.equals(futureqq);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        java.util.concurrent.Future<Integer> future = executorService.submit(() -> {

            System.out.println(Thread.currentThread() + "1");
            Thread.sleep(30000);
            if (1 > 0) throw new RuntimeException("test-终止");
            return 1;

        });
//
        java.util.concurrent.Future<Integer> future2 = executorService.submit(() -> {

            System.out.println(Thread.currentThread() + "2");
            return 2;

        });
//
        java.util.concurrent.Future<Integer> future3 = executorService.submit(() -> {

            System.out.println(Thread.currentThread() + "3");
            return 3;

        });

        {
            // executorService.shutdownNow(); 立即关闭
            // 不在接受任务，等待任务执行完就会关闭
            executorService.shutdown();

            try {
                // 等待线程池中的任务执行完毕
                executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
                Object obj = future.get();
                if (obj instanceof Exception) {
                    // 失败了
                }

            } catch (InterruptedException e) {

                int a = 10;

            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }



        int a = 10;


    }


    public static class Future1 {

        public static void main(String[] args)   {

            ExecutorService executorService = Executors.newFixedThreadPool(3);

            Callable<Integer> callable1 = () -> {

                Thread.sleep(30000);
                return 1;
            };

            Callable<Integer> callable2 = () -> {

                return 2;
            };

            Callable<Integer> callable3 = () -> {

                return 3;
            };

            try {

                List<java.util.concurrent.Future<Integer>> futureList = executorService.invokeAll(Arrays.asList(callable1, callable2, callable3));
                int a = 10;

                executorService.submit(() -> {

                    System.out.println("1");

                });
            } catch (InterruptedException e) {

            }



        }
    }

}




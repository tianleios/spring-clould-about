package com.tl.algorithm;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by tianlei on 2019/2/11
 */
public class TopK {

    @Test
    public void topKMin() {
        int[] arr = {1, 9, 3, 4, 7};
        minK(arr, 4);
    }

    @Test
    public void topKMax() {
        int[] arr = {1, 9, 3, 4, 7};
        maxK(arr, 4);
    }

    //最大的几个数用小顶堆
    public void maxK(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {

            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else {
                if (arr[i] > queue.peek()) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }

        }
        printQueue(queue);
    }

    //最小的几个数用大顶堆
    public void minK(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> {
            return o2 - o1;
        });

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else {
                if (arr[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }

        }
        printQueue(queue);
    }


    public void printQueue(Queue queue) {
        queue.stream().forEach(System.out::print);
    }


    @Test
    public void classLoader() {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}

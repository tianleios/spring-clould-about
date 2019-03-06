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
        minK2(arr, 4);
    }

    @Test
    public void topKMax() {
        int[] arr = {1, 9, 3, 4, 7};
        maxK2(arr, 4);
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

    /**
     * 最大的值， 用最小堆
     * @param arr
     * @param k
     */
    public void maxK2(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int a : arr) {
            if (queue.size() < k) {
                queue.add(a);
            } else {
                if (a > queue.peek()) {
                    queue.poll();
                    queue.add(a);
                }
            }
        }

        printQueue(queue);

    }

    public void minK2(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int a : arr) {
            if (queue.size() < k) {
                queue.add(a);
            } else {
                if (a < queue.peek()) {
                    queue.poll();
                    queue.add(a);
                }
            }
        }
        printQueue(queue);

    }


}

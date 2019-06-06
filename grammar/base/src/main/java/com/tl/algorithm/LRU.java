package com.tl.algorithm;

import java.util.LinkedHashMap;

/**
 * Created by tianlei on 2019/1/6
 */
public class LRU {




    public static class LRUMap<K, V>  {

        private Integer cacheSize;

        private LinkedHashMap<K, V> cacheMap;

        public  LRUMap(int maxSize) {
            cacheSize = maxSize;
            cacheMap = new LinkedHashMap<K, V>() {
//                @Override
//                protected boolean remove() {
//                    return size() > cacheSize;
//                }
//            };
            };
        }


    }


    public static void main(String[] args) {

        //输入: nums = [-1,0,3,5,9,12], target = 9

        //int[] arr = {-1,0,3,5,9,12};
        int[] arr = {0, 1};
        int target = 0;



        System.out.println(value(arr, target , 0, arr.length - 1));


    }

    private static int value(int[] arr, int target, int left, int right ) {
        if (left == right ) {
            if (arr[left] == target) {
                return left;
            }
            return -1;
        }

        int midIndex = (int)Math.ceil((left + right)/2);
        int midValue = arr[midIndex];
        if (midValue >= target) {
            return value(arr, target, left, midIndex);
        } else {
            return value(arr, target, midIndex + 1, right);
        }
    }

}

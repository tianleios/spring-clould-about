package com.tl.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by tianlei on 2018/11/29
 */

public class Sort {

    public static void main(String[] args) {

    }

    public static void swap(int a, int b) {
        int c = a;
        a = b;
        b = c;
    }

    public static void printArr(int[] arr) {
        String s = Arrays.stream(arr).boxed().map(Objects::toString).collect(Collectors.joining(","));
        System.out.println(s);
    }

    @Test
    public void maoPao() {

        int[] arr = new int[]{1, 5, 3, 5, 2, 8};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int c = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = c;
                }
            }

        }
        printArr(arr);

    }

    @Test
    public void max() {

        int[] arr = new int[]{2, 4, 6, 5, 3, 4, 7, 7};
        int max = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            max = max < arr[i] ? arr[i] : max;
        }
        System.out.println(max);

    }

}

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
    public void quickSort() {
        int[] arr = new int[]{1, 3453, 3, 5435, 2, 5643646};

        quickSort(arr, 0, arr.length - 1);
        printArr(arr);

    }


    public void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int p = quickSortExec(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }


    public int quickSortExec(int[] arr, int left, int right) {

        int temp = arr[left];

        while (left < right) {

            while (left < right && arr[right] >= temp) {
                right--;
            }

            arr[left] = arr[right];

            ////////////////////////////////////////////
            while (left < right && arr[left] <= temp) {
                left++;
            }

            arr[right] = arr[left];

        }
        arr[left] = temp;
        return left;

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


    @Test
    public void test() {
        int a = 10;
        change(a);
        System.out.println(a);
    }

    public void change(int a) {
        a = a - 1;
    }

}

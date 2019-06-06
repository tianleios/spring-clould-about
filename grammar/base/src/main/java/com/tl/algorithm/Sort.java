package com.tl.algorithm;

import org.junit.Test;

import java.math.BigInteger;
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

        System.out.println(String.format("%.2f", 3.123));

//        int[] arr = new int[]{1, 5, 3, 5, 2, 8};
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int c = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = c;
//                }
//
//            }
//        }
//        printArr(arr);

    }


    @Test
    public void mp2() {
        int[] arr = {1, 2, 3, 4, 1, 2};

        for (int i = 0; i < arr.length - 1; i ++) {
            for (int j = 0; j < arr.length - 1 - i; j ++) {

                if (arr[j] > arr[j + 1]) {
                    int c = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = c;
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


    @Test
    public void ta() {

        BigInteger b1 = new BigInteger("-3");

        BigInteger b2 = new BigInteger("2");

        System.out.println(b1.mod(b2).toString());


    }


    //***************   quick sort
    @Test
    public void qsTest() {
        int[] arr = {1, 4, 3, 2, 1, 1, 10, 100};
        qs2(arr, 0, arr.length - 1);
        printArr(arr);

    }

    public void qs(int[] arr, int left, int right) {

        if (left < right) {
            int z = qsz(arr, left, right);
            qs(arr, left, z - 1);
            qs(arr, z + 1, right);

        }


    }

    // 2 3 1 4
    public int qsz(int[] arr, int left, int right) {


        int temp = arr[left];


        while (left < right) {
            while (left < right && arr[right] > temp) {

                right--;
            }

            arr[left] = arr[right];

            while (left < right && arr[left] <= temp) {
                left++;
            }

            arr[right] = arr[left];
        }

        arr[left] = temp;

        return left;

    }


    //--//
    public void qs2(int[] arr, int left, int right) {

        if (left < right) {
            int p = qsz(arr, left, right);
            qs2(arr,left, p);
            qs2(arr, p + 1, right);
        }

    }

    public int qsz2(int[] arr, int left, int right) {

        int temp = arr[left];

        while (left < right) {
            if (left < right && arr[right] >= temp) {
                right --;
            }

            arr[left] = arr[right];

            if (left < right && arr[left] < temp) {
                left ++;
            }

            arr[right] = arr[left];
        }

        arr[left] = temp;
        return left;
    }

}


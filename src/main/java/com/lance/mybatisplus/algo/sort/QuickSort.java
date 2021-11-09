package com.lance.mybatisplus.algo.sort;

import java.util.Arrays;

/**
 * @program: mybatisplus  QuickSort
 * @description:
 * @author: flchen
 * @create: 2021-10-24 00:12
 **/

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 4, 5, 2, 13, 15, 1, 11, 9};
        qs(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));

    }

    static void qs(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        String str = new String();
        Class clazz = str.getClass();

        if (i < j) {
            int target = arr[i];
            while (i < j) {
                while (i < j && arr[j] >= target) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] < target) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = target;
            qs(arr, start, i - 1);
            qs(arr, i + 1, end);
        }
    }

}

package com.lance.mybatisplus.algo;

import java.util.Arrays;

/**
 * @program: mybatisplus  Solution
 * @description:
 * @author: flchen
 * @create: 2021-04-18 19:01
 **/

public class Solution {
    static int[] arr = {3, 1, 2, 6, 4, 9, 0};

    public static void main(String[] args) {
        Arrays.stream(arr).forEach(System.out::println);
        sort3(0, arr.length-1);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }

    // maopao
    static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //选择
    static void sort2(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    // 快排
    static void sort3(int start, int end) {
        if (start < end) {
            int num = arr[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && arr[j] > num) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i] <= num) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
                arr[i] = num;
            }
            sort3(start, i-1);
            sort3(i+1, end);
        }
    }
}

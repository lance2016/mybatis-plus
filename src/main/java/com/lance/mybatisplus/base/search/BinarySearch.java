package com.lance.mybatisplus.base.search;

/**
 * @program: mybatisplus  BinarySearch
 * @description:
 * @author: flchen
 * @create: 2021-07-14 17:05
 **/

public class BinarySearch {
    static int[] arr = {0,1, 3, 4,  5, 9, 10};

    public static void main(String[] args) {
        System.out.println(":"+search2(arr,15,0,arr.length-1));
    }

//    static int search(int[] arr, int target, int start, int end) {
//
//        int mid = (start + end) / 2;
//        if (arr[mid] < target) {
//            return search(arr, target, mid + 1, end);
//        } else if (arr[mid] > target) {
//            return search(arr, target, start, mid - 1);
//        } else if (arr[mid] == target) {
//            return target;
//        }
//    }

    static int search2(int[]arr, int target, int start, int end){
        while(start<=end){
            int mid = (start + end) / 2;
            if(target > arr[mid]){
                start = mid + 1;
            }else if(target< arr[mid]){
                end = mid - 1;
            }else if(target == arr[mid]){
                return mid;
            }
        }
        return -1;
    }

}

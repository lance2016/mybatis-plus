package com.lance.mybatisplus.algo;

/**
 * @program: mybatisplus  BinarySearch
 * @description: 二分查找，返回最左侧，最右侧查找元素
 * @author: flchen
 * @create: 2021-10-09 17:37
 **/

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 4, 4, 4, 4, 9, 10};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("bs "+i+" : "+bs(arr, 0,arr.length - 1,i));
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + bsLeft(arr, 0, arr.length - 1, i));
        }
    }

    static int bs(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < arr[mid]) {
                r = mid - 1;
            } else if (target > arr[mid]) {
                l = mid + 1;
            }else if (target == arr[mid]) {
                return mid;
            }
        }
        return -1;
    }


    static int bsLeft(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // 最找到目标值时，继续找目标值左边的区间，看看是否还有
            // 极限情况下，mid==l==r==目标值左侧，此时条件仍然成立，l+1,所以最后返回l;
            // 同理
            if (target <= arr[mid]) {
                r = mid - 1;
            } else if (target > arr[mid]) {
                l = mid + 1;
            }
        }
        // 还需要考虑最终找到的是否和目标值相等，不相等则表明数组中不存在目标值
        return target == arr[l] ? l : -1;
    }
}

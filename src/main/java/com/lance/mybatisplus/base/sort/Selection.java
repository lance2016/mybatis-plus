package com.lance.mybatisplus.base.sort;

/**
 * @program: java-base  Selection
 * @description:
 * @author: flchen
 * @create: 2021-06-09 14:18
 **/

public class Selection extends Ordering {


     @Override
     protected void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(nums, i, min);
            }
        }
    }

}

package com.lance.mybatisplus.base.sort;

/**
 * @program: java-base  Insert
 * @description:
 * @author: flchen
 * @create: 2021-06-10 10:32
 **/

public class Insert extends Ordering {
    @Override
    protected void sort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}

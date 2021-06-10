package com.lance.mybatisplus.base.sort;

/**
 * @program: java-base  Shell
 * @description:
 * @author: flchen
 * @create: 2021-06-10 11:20
 **/

public class Shell extends Ordering {
    @Override
    protected void sort(int[] nums) {
        int len = nums.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (nums[j] < nums[j - gap]) {
                        swap(nums, j, j - gap);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}

package com.lance.mybatisplus.base.sort;

/**
 * @program: java-base  Bubble
 * @description:
 * @author: flchen
 * @create: 2021-06-09 14:31
 **/

public class Bubble extends Ordering {

    @Override
    protected void sort(int nums[]) {
        int len = nums.length;
        boolean sorted = false;
        for (int i = 0; i < len - 1 && !sorted; i++) {
            sorted = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    sorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}

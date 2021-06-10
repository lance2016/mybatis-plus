package com.lance.mybatisplus.base.sort;

/**
 * @program: java-base  Quick
 * @description:
 * @author: flchen
 * @create: 2021-06-10 11:43
 **/

public class Quick extends Ordering {
    @Override
    protected void sort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int i = l, j = r;
            int x = nums[l];
            while (i < j) {
                while (i < j && nums[j] > x) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }

                while (i < j && nums[i] <= x) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
                nums[i] = x;
            }
            quickSort(nums, l, i-1);
            quickSort(nums, i + 1, r);

        }

    }
}

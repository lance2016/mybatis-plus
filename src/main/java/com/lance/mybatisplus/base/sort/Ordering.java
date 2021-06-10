package com.lance.mybatisplus.base.sort;

abstract class Ordering {
    void print() {
        int[] nums = new int[]{101, 21, 12, 12, 5, 8, 19, 7, 4, 3};
        sort(nums);
        String className = this.getClass().getName();
        System.out.println(className.substring(className.lastIndexOf(".") + 1));
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    protected abstract void sort(int[] nums);


    protected void swap(int[] nums, int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}

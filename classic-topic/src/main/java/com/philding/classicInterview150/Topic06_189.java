package com.philding.classicInterview150;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */

public class Topic06_189 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr,3);
        System.out.println(Arrays.toString(arr));


    }


    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] newArr = new int[length];

        for (int i = 0; i < length; i++) {
            newArr[(i+k)%length] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, length);
    }

}

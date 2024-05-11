package com.philding.classicInterview150;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */

public class Topic04_80 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] arr = { 1, 1, 2};
        int i = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(i);

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int left = 2;
        int right = 2;
        while (right < nums.length) {
            if (nums[right] != nums[left-2]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;
    }
}

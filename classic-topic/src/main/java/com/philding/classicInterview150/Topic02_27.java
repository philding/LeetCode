package com.philding.classicInterview150;

import java.util.Arrays;

public class Topic02_27 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int var = 3;
        int i = removeElementOptimize(arr, var);
        System.out.printf(String.valueOf(i));
        System.out.println(Arrays.toString(arr));
    }


    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        while (right < length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static int removeElementOptimize(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }



}

package com.philding;

import java.util.Arrays;

public class Topic03_26 {
    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] arr = { 1, 1, 2};
        int i = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(i);

    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
            right++;
        }

        return left+1;
    }


}

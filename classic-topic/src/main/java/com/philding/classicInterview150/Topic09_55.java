package com.philding.classicInterview150;

public class Topic09_55 {
    public static void main(String[] args) {


    }

    public boolean canJumpTanXin(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (i <= max) {
                max = Math.max(nums[i] + i, max);
                if (max >= length - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canJumpDP(int[] nums) {

        return true;
    }




}

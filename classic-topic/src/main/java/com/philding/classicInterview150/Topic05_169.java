package com.philding.classicInterview150;

import java.util.Arrays;

/**
 * @Author: Qf.Ding
 * @CreateTime: 2024-05-11
 * @Description:
 * @Version: 1.0
 */
public class Topic05_169 {

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement01(arr);

        System.out.println(i);
    }


    public static int majorityElement01(int[] nums) {
        //先排序，再取中位数
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public static int majorityElement02(int[] nums) {
        //先放进hashmap，然后取最大值


        return 0;
    }


}

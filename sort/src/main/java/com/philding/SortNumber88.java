package com.philding;

import java.util.Arrays;

public class SortNumber88 {
    public static void main(String[] args) {

        int[] numA = {1, 2, 3,0,0,0};

        int[] numB = {2, 5, 6};

        merge(numA, 3, numB, 3);
        System.out.println(Arrays.toString(numA));

    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //合并
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);

    }


    public static void mergeOptimize(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] finalNums = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {

            if (p1 == m) {
                cur = nums2[p2];
                p2++;
            } else if (p2 == n) {
                cur = nums1[p1];
                p1++;
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1];
                p1++;
            } else {
                cur = nums2[p2];
                p2++;
            }
            finalNums[p1 + p2 - 1] = cur;
        }
        if (m + n >= 0) System.arraycopy(finalNums, 0, nums1, 0, m + n);
    }


    public static void mergeOptimize2(int[] nums1, int m, int[] nums2, int n) {

        int total = m + n;
        int[] arr = new int[total];
        int idx = 0;
        for (int i = 0, j = 0; i < m || j < n;) {
            if (i < m && j < n) {
                arr[idx] = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
                i++;j++;idx++;
            } else if (i < m) {
                arr[idx] = nums1[i];
                i++;idx++;
            } else if (j < n) {
                arr[idx] = nums2[j];
                j++;idx++;
            }
        }
        System.arraycopy(arr, 0, nums1, 0, total);
    }

    public static void mergeOptimizeBest(int[] nums1, int m, int[] nums2, int n) {
        //原地合并，从后往前
        int i = m - 1, j = n - 1;
        int idx = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                nums1[idx] = nums1[i] >= nums2[j] ? nums1[i] : nums2[j];
                idx--;i--;j--;
            } else if (i >= 0) {
                nums1[idx] = nums1[i];
                idx--;i--;
            } else {
                nums1[idx] = nums2[j--];
                idx--;j--;
            }
        }
    }
}


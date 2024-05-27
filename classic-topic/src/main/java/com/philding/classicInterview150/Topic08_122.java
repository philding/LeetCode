package com.philding.classicInterview150;

public class Topic08_122 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            //持有
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            //不持有
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[length - 1][1];
    }


    public int maxProfitEasy(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int temp = prices[i] - prices[i - 1];
                sum += temp;
            }
        }
        return sum;
    }

}

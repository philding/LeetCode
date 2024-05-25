package com.philding.classicInterview150;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Topic07_121 {
    public static void main(String[] args) {


    }

    public static int maxProfitDP(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        //转态转移方程

        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i]+dp[i-1][0]);
        }
        return dp[len - 1][1];
    }

    public static int maxProfit(int[] prices) {

        // 可交易次数
        int k = 1;
        // [天数][交易次数][是否持有股票]
        int[][][] dp = new int[prices.length][k + 1][2];

        // bad case
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                // dp公式
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][k][0] > 0 ? dp[prices.length - 1][k][0] : 0;
    }


    public static int maxProfitViolentSolution(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }

        int maxProfit = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int betterProfit = prices[j] - prices[i];
                if (betterProfit > maxProfit) {
                    maxProfit = betterProfit;
                }

            }
        }
        return maxProfit;
    }
}

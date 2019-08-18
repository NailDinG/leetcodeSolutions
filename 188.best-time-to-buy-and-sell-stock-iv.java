/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;

        int maxProfit = 0;
        if (k > n / 2) {
            for (int i = 1; i < n; i ++) {
                int diff = prices[i] - prices[i - 1];
                if (diff > 0) {
                    maxProfit += diff;
                }
            }
            return maxProfit;
        }
        
        int[][] dp = new int[k + 1][n];
        int localMax = Integer.MIN_VALUE;

        for (int i = 1; i <= k; i ++) {
            for (int j = 1; j < n; j ++) {
                localMax = Math.max(localMax, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]);
            }
            localMax = Integer.MIN_VALUE;
        }
        return dp[k][n - 1];
    }
}


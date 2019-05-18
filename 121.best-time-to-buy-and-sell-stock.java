/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 * dp(n) = max(dp(n - 1), prices[n] - min)
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        return dp(prices, Integer.MAX_VALUE, 0);
        
    }

    private int dp(int[] prices, int min, int n) {
        if (n > prices.length - 1) {
            return 0;
        }
        if (prices[n] < min) {
            min = prices[n];
            return dp(prices, min, n + 1);
        } else {
            return Math.max(dp(prices, min, n + 1), prices[n] - min);
        }
    }
}


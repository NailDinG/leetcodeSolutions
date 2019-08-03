/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            int buy = prices[i];
            int sold = prices[i + 1];
            if (sold - buy > 0) {
                res += (sold - buy);
            }
        }
        return res;
    }
}


/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */
class Solution {

    int[] dp;

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        return helper(n);
    }

    public int helper(int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int res = 0;
        for (int i = 0; i < n; i ++) {
            res += helper(i) * helper(n - i - 1);
        }
        dp[n] = res;
        return res;
    }
}


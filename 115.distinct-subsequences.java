/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int i = 0; i <= s.length(); i ++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < t.length(); i ++) {
            for (int j = 0; j < s.length(); j ++) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        return dp[t.length()][s.length()];
    }
}


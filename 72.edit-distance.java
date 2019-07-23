/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 * https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)
 * 
 * Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
 * 
 *   f(i, j) = f(i - 1, j - 1)
 * 
 * Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
 * 
 *   f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
 * 
 * 
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i ++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j ++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int a = dp[i][j];
                    int b = dp[i][j + 1];
                    int c = dp[i + 1][j];
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(a, b), c);
                }
            }
        }

        return dp[m][n];
    }
}


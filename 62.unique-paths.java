/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */
class Solution {
    int[][] mem;
    public int uniquePaths(int m, int n) {
        mem = new int[m][n];
        return dp(m - 1, n - 1);
    }

    private int dp(int m, int n) {
        if (m == 0 || n == 0) {
            mem[m][n] = 1;
            return 1;
        }
        if (mem[m][n] > 0) {
            return mem[m][n];
        }
        mem[m][n] = dp(m - 1, n) + dp(m, n - 1);
        return mem[m][n];
    }

}


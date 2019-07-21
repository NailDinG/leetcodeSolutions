/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */
class Solution {
    Integer[][] mem;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        mem = new Integer[m][n];
        return dp(m - 1, n - 1, obstacleGrid);
    }

    private int dp(int m, int n, int[][] obstacleGrid) {
        if (m == 0 && n == 0) {
            mem[m][n] = obstacleGrid[m][n] == 0 ? 1 : 0;
            return mem[m][n];
        }
        
        if (obstacleGrid[m][n] == 1) {
            mem[m][n] = 0;
            return 0;
        }
        if (mem[m][n] != null) {
            return mem[m][n];
        }

        if (m == 0) {
            mem[m][n] = dp(m, n - 1, obstacleGrid);
            return mem[m][n];
        }
        if (n == 0) {
            mem[m][n] = dp(m - 1, n, obstacleGrid);
            return mem[m][n];
        }
        mem[m][n] = dp(m - 1, n, obstacleGrid) + dp(m, n - 1, obstacleGrid);
        return mem[m][n];
    }
}


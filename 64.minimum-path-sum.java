/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 * dp: dp(i, j) = min(dp(i-1, j) + grid(i, j), dp(i, j-1) + grid(i, j))
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] mem = new int[grid.length][grid[0].length];
        return dp(grid, mem, grid.length-1, grid[0].length-1);
    }

    private int dp(int[][] grid, int[][] mem, int i, int j) {
        if (i <= 0 && j <= 0) {
            mem[0][0] = grid[0][0];
            return grid[0][0];
        }
        if (mem[i][j] != 0) {
            return mem[i][j];
        }
        
        if (i == 0) {
            mem[i][j] = dp(grid, mem, i, j-1) + grid[i][j];
        } else if (j == 0) {
            mem[i][j] = dp(grid, mem, i-1, j) + grid[i][j];
        } else {
            mem[i][j] = Math.min(dp(grid, mem, i-1, j), dp(grid, mem, i, j-1))  + grid[i][j];
        }
        return mem[i][j];
    }
}


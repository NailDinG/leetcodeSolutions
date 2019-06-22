/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */
class Solution {
    int res = 0;
    int[][] mem;
    int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                dfs(matrix, i, j);
            }
        }
        //return dfs(matrix, 2, 1);
        return res;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return 0;
        }
        if (mem[row][col] > 0) {
            return mem[row][col];
        }
        int cur = matrix[row][col];
        //System.out.println(cur);
        int max = 1;
        for (int[] dir: dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            // System.out.print(String.valueOf(i) + ", ");
            //System.out.println(String.valueOf(j)+": " + String.valueOf(matrix[i][j]));
            // System.out.println(String.valueOf(j));
            int tmp = 0;
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length 
                && matrix[i][j] > matrix[row][col]) {
                    
                tmp = dfs(matrix, i, j) + 1;
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        mem[row][col] = max;
        res = Math.max(max, res);
        return max;
    }
}


/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = n / 2;

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n - 1 - 2 * i; j ++) {
                int cur = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - 1 - i - j][i];
                matrix[n - 1 - i - j][i] = matrix[n - 1 - i][n - 1 - i - j];
                matrix[n - 1 - i][n - 1 - i - j] = matrix[i + j][n - 1 - i];
                matrix[i + j][n - 1 - i] = cur;
            }
        }
    }
}


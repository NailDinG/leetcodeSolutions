/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        
        while (row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length) {
            int cur = matrix[row][col];
            if (cur > target) {
                col --;
            } else if (cur < target) {
                row ++;
            } else {
                return true;
            }
        }

        return false;
    }
}


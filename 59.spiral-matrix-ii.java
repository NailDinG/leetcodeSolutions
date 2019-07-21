/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */
class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        int minRow = 0;
        int minCol = 0;
        int maxRow = n - 1;
        int maxCol = n - 1;
        int num = 1;

        while (minRow <= maxRow && minCol <= maxCol) {
            // right
            for (int i = minCol; i <= maxCol; i ++) {
                res[minRow][i] = num ++;
            }
            minRow ++;
            // down
            for (int i = minRow; i <= maxRow; i ++) {
                res[i][maxCol] = num ++;
            }
            maxCol --;
            // left
            for (int i = maxCol; i >= minCol; i --) {
                res[maxRow][i] = num ++;
            }
            maxRow --;
            // up
            for (int i = maxRow; i >= minRow; i --) {
                res[i][minCol] = num ++;
            }
            minCol ++;
        }
        return res;
    }
}


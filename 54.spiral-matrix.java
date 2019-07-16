import java.util.*;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new LinkedList<>();
        }
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        List<Integer> res = new LinkedList<>();
        int rowBegin = 0;
        int colBegin = 0;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // go right
            for (int i = colBegin; i <= colEnd; i ++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin ++;
            // go down
            for (int i = rowBegin; i <= rowEnd; i ++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd --;
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i --) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd --;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i --) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin ++;            
        }

        return res;
    }
}


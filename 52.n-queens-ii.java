import java.util.ArrayList;
import java.util.Arrays;
/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */
class Solution {
    int cnt = 0;
    public int totalNQueens(int n) {
        for (int i = 0; i < n; i ++) {
            int[] position = new int[n];
            position[0] = i;
            solve(1, position, n);   
        }
        return cnt;
    }
    
    public void solve(int row, int[] position, int n) {
        if (row == n) {
            // add to result
            cnt ++;
        }

        for (int col = 0; col < n; col ++) {
            if (isOk(row, col, position, n)) {
                position[row] = col;
                solve(row + 1, position, n);
            }
        }
    }

    private boolean isOk(int row, int col, int[] result, int n) {
        int leftup = col - 1;
        int rightup = col + 1;
        for(int i = row - 1; i>=0; i-- ) {
            if (result[i] == col) {
                return false;
            }
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < n) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            leftup -- ;
            rightup ++ ;
        }
        return true;
    }
}


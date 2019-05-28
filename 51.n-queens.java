import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */
class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        
        for (int i = 0; i < n; i ++) {
            int[] position = new int[n];
            position[0] = i;
            solve(1, position, n);   
            
        }
        return res;
    }

    public void solve(int row, int[] position, int n) {
        if (row == n) {
            // add to result
            char[] tmp = new char[n];
            Arrays.fill(tmp, '.');
            ArrayList<String> tmpList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] newTmp = tmp.clone();
                newTmp[position[i]] = 'Q';
                tmpList.add(String.valueOf(newTmp));
            }
            res.add(tmpList);
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


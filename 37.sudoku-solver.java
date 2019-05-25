import java.util.Arrays;

/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */
class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int pos) {
        if (pos == 81) {
            return true; // already solved
        }
        // trans pos to actual position in the char array
        int i = pos / 9;
        int j = pos % 9;
        if (board[i][j] != '.') {
            return dfs(board, pos + 1);
        }
        boolean[] flags = new boolean[10];
        // find which num could be filled in this position
        findValidateNums(board, i, j, flags);
        for(int k = 1; k <= 9; k ++) {
            if (flags[k]) {
                board[i][j]=(char)('0'+k);
                if (dfs(board, pos + 1)) {
                    return true;
                }
            }
        }
        board[i][j] = '.';
        return false;
        
    }

    private void findValidateNums(char[][] board, int i, int j, boolean[] flags) {
        Arrays.fill(flags, true);
        for (int k = 0; k < 9; k ++) {
            if (board[i][k] != '.') {
                flags[board[i][k] - '0'] = false;
            }
            if (board[k][j] != '.') {
                flags[board[k][j] - '0'] = false;
            }
            int r = i / 3 * 3 + k / 3;
            int c = j / 3 * 3 + k % 3;
            if (board[r][c] != '.') {
                flags[board[r][c] - '0'] = false;
            }
        }
    }
}


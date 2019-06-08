import java.util.HashMap;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 * See a cell wether can reach the edge or not
 */
class Solution {

    public void solve(char[][] board) {
        if (board == null || board.length < 1) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i ++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j ++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
            return;
        }
        if (board[row][col] == 'O') {
            board[row][col] = '*';
        }
        if (row - 1 > 0 && board[row - 1][col] == 'O') {
            dfs(board, row - 1, col);
        }
        if (row + 1 < board.length - 1 && board[row + 1][col] == 'O') {
            dfs(board, row + 1, col);
        }
        if (col - 1 > 0 && board[row][col - 1] == 'O') {
            dfs(board, row, col - 1);
        }
        if (col + 1 < board[0].length - 1 && board[row][col + 1] == 'O') {
            dfs(board, row, col + 1);
        }
    }
}


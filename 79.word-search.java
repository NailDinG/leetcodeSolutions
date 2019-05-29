import java.util.LinkedHashSet;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */
class Solution {
    
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        boolean[][] mem = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[0].length; col ++) {
                if (exist(board, mem, row, col, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, boolean[][] mem, int row, int col, int pos, String word) {
        if (pos == word.length()) {
            return true;
        }
        if (row > board.length - 1 || row < 0) {
            return false;
        }
        if (col > board[0].length -1 || col < 0) {
            return false;
        }
        if (board[row][col] != word.charAt(pos)) {
            return false;
        } else {
            if (mem[row][col]) {
                return false;
            } else {
                if (pos == word.length() - 1) {
                    return true;
                }
                mem[row][col] = true;
                boolean res = exist(board, mem, row + 1, col, pos + 1, word) || exist(board, mem, row, col + 1, pos + 1, word) || exist(board, mem, row - 1, col, pos + 1, word) ||  exist(board, mem, row, col - 1, pos + 1, word);
                mem[row][col] = false;
                return res;
            }
            
        }
        
    }
}


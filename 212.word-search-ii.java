import java.util.*;
/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */
class Solution {
    Set<String> res = new HashSet<>();
    int[][] directions = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>(res);
        }
        int m = board.length;
        int n = board[0].length;
        for (String word : words) {
            for (int i = 0; i < m; i ++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        findWord(board, word, 0, i, j, new boolean[m][n]);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    private boolean findWord(char[][] board, String word, int index, int i, int j, boolean[][] mem) {
        if (index >= word.length()) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;

        if (i >= m || j >= n || i < 0 || j < 0 || mem[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        mem[i][j] = true;
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];
            
            if(findWord(board, word, index + 1, row, col, mem)) {
                res.add(word);
                break;
            }
        }
        mem[i][j] = false;
        return false;

    }
}


import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String, HashSet<Character>> record = new HashMap<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (record.containsKey(row + "row")) {
                    if (record.get(row+"row").contains(board[row][col])) {
                        return false;
                    } else {
                        record.get(row + "row").add(board[row][col]);
                    }
                } else {
                    HashSet<Character> hashSet = new HashSet<>();
                    hashSet.add(board[row][col]);
                    record.put(row + "row", hashSet);
                }
                if (record.containsKey(col + "col")) {
                    if (record.get(col+"col").contains(board[row][col])) {
                        return false;
                    } else {
                        record.get(col + "col").add(board[row][col]);
                    }
                } else {
                    HashSet<Character> hashSet = new HashSet<>();
                    hashSet.add(board[row][col]);
                    record.put(col + "col", hashSet);
                }
                String blockKey = row/3 + "+" + col/3;
                if (record.containsKey(blockKey)) {
                    if (record.get(blockKey).contains(board[row][col])) {
                        return false;
                    } else {
                        record.get(blockKey).add(board[row][col]);
                    }
                } else {
                    HashSet<Character> hashSet = new HashSet<>();
                    hashSet.add(board[row][col]);
                    record.put(blockKey, hashSet);
                }
            }
        }
        return true;
    }
}


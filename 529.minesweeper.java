import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */
class Solution {
    int[] dirX = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
    int[] dirY = new int[]{-1, 1, 0, 0, -1, 1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return board;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int x = click[0];
        int y = click[1];
        if (x >= 0 && x < m && y >= 0 && y < n) {
            //dfs
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
                return board;
            }
            queue.add(click);
            while (!queue.isEmpty()) {
                for (int z = 0; z < queue.size(); z++) {
                    int[] cur = queue.poll();
                    x = cur[0];
                    y = cur[1];
                    if (board[x][y] != 'E') {
                        continue;
                    }
                    board[x][y] = '0';
                    for (int i = 0; i < 8; i ++) {
                        int row = x + dirX[i];
                        int col = y + dirY[i];
                        if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                            if (board[row][col] == 'M') {
                                board[x][y]++;
                            }
                        }
                    }
                    if (board[x][y] == '0') {
                        board[x][y] = 'B';
                        for (int i = 0; i < 8; i ++) {
                            int row = x + dirX[i];
                            int col = y + dirY[i];
                            if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                                if (board[row][col] == 'E') {
                                    queue.add(new int[]{row, col});
                                }
                            }
                        }
                    }
                    visited[x][y] = true;
                }
            }
        } else {
            return board;
        }
        return board;
    }
}


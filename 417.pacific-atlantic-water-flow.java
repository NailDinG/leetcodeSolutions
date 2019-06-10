import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */
class Solution {

    List<int[]> res = new ArrayList<>();

    class Cell {
        int row;
        int col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        boolean[][] rP = new boolean[matrix.length][matrix[0].length];
        boolean[][] rA = new boolean[matrix.length][matrix[0].length];
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Cell> pQueue = new LinkedList<>();
        Queue<Cell> aQueue = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i ++) {
            rP[i][0] = true;
            pQueue.add(new Cell(i, 0));
            rA[i][n - 1] = true;
            aQueue.add(new Cell(i, n - 1));
        }

        for (int j = 0; j < n; j ++) {
            if (!rP[0][j]) {
                rP[0][j] = true;
                pQueue.add(new Cell(0, j));
            }
            if (!rA[m - 1][j]) {
                rA[m - 1][j] = true;
                aQueue.add(new Cell(m - 1, j));
            }
            
        }

        while (!pQueue.isEmpty()) {
            Cell cur = pQueue.poll();
            int curRow = cur.row;
            int curCol = cur.col;

            for (int[] dir : dirs) {
                int row = curRow + dir[0];
                int col = curCol + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n 
                    && matrix[row][col] >= matrix[curRow][curCol] && !rP[row][col]) {
                    rP[row][col] = true;
                    pQueue.add(new Cell(row, col));
                }
            }
        }

        while (!aQueue.isEmpty()) {
            Cell cur = aQueue.poll();
            int curRow = cur.row;
            int curCol = cur.col;

            for (int[] dir : dirs) {
                int row = curRow + dir[0];
                int col = curCol + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n 
                    && matrix[row][col] >= matrix[curRow][curCol] && !rA[row][col]) {
                    rA[row][col] = true;
                    aQueue.add(new Cell(row, col));
                }
            }
        }

        for (int i = 0; i < m ; i ++) {
            for (int j = 0; j < n ; j ++){
                if (rP[i][j] && rA[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        
        return res;
    }
}


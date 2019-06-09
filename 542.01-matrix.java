import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */
class Solution {
    int[][] res;
    int[][] dirs = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
    boolean[][] visited;
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    res[i][j] = 0;
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
                
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i ++) {
                int row = x + dirs[i][0];
                int col = y + dirs[i][1];
                if (row < m && row >= 0 && col < n && col >= 0 && res[row][col] == Integer.MAX_VALUE) {
                    res[row][col] = Math.min(res[row][col], res[x][y] + 1);
                    queue.add(new int[]{row, col});
                }
            }
        }
        return res;
    }
}


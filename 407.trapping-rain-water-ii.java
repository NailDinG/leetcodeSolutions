import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=407 lang=java
 *
 * [407] Trapping Rain Water II
 */
class Solution {

    class Cell {
        int row;
        int col;
        int height;
        Cell(int row, int col, int height){
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i ++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0; i < n; i ++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new Cell(0, i, heightMap[0][i]));
            queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int[] dir: dirs) {
                int row = cur.row + dir[0];
                int col = cur.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    res += Math.max(0, cur.height - heightMap[row][col]);
                    queue.offer(new Cell(row, col, Math.max(cur.height, heightMap[row][col])));
                }
            }
        }

        return res;
    }
}


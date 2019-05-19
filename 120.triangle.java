import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */
class Solution {
    Integer[][] mem;
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        mem = new Integer[triangle.size()][triangle.size()];
        return dp(triangle, 0, 0);
    }

    private int dp(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        if (mem[row][col] != null) {
            return mem[row][col];
        }
        mem[row][col] = Math.min(dp(triangle, row + 1, col), dp(triangle, row + 1, col + 1)) + triangle.get(row).get(col);
        return mem[row][col];
    }
}


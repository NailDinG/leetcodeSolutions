/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */
class Solution {
    int min = Integer.MAX_VALUE;
    public int numSquares(int n) {
        numSquares(n, 1);
        return min;
    }

    private void numSquares(int n, int level) {
        if (level > min) {
            return;
        }
        int m = new Double(Math.sqrt(n)).intValue();
        for (int i = m; i > 0; i --) {
            int tmp = i * i;
            if (tmp > n) {
                break;
            }
            if (tmp == n && level < min) {
                min = level;
                continue;
            }
            if (tmp < n) {
                numSquares(n - tmp, level + 1);
            }
        }
    }
}


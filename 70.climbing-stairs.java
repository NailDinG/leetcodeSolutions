/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++ ) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}


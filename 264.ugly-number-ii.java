import java.util.*;
/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 * Use Merge Sort
 */
class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] uglys = new int[n];
        uglys[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i ++) {
            int cur = Math.min(factor2, Math.min(factor3, factor5));
            uglys[i] = cur;
            if (factor2 == cur) {
                factor2 = 2 * uglys[++index2];
            }
            if (factor3 == cur) {
                factor3 = 3 * uglys[++index3];
            }
            if (factor5 == cur) {
                factor5 = 5 * uglys[++index5];
            }
        }
        return uglys[n - 1];
    }
}


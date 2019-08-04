import java.util.List;
import java.util.ArrayList;
/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */
class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        boolean[][] isPal = new boolean[n + 1][n + 1];
        int[] cut = new int[n];

        for (int i = 0; i < n; i ++) {
            cut[i] = i;
            for (int j = 0; j <= i; j ++) {
                if (c[i] == c[j] && (j + 1 > i - 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    cut[i] = j == 0 ? 0 : Math.min(cut[i], cut[j - 1] + 1);
                }
            }
        }
        return cut[n - 1];
    }

    
}


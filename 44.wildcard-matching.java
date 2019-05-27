/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */
class Solution {

    Boolean[][] mem = null;

    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        if (p.isEmpty()) {
            return false;
        }
        if (p.equals("*")) {
            return true;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j] || dp[i][j];
                } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i+1][j+1] = dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}


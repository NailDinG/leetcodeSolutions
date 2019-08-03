/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */
class Solution {

    Boolean[][][] dp = null;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null || s2 == null || s1 == null) {
            if (s1 == null && s3 != null && s2 != null) {
                return s3.equals(s2);
            } else if (s2 == null && s3 != null && s2 != null) {
                return s3.equals(s1);
            } else if (s1 == null && s2 == null && s3 == null) {
                return true;
            } else {
                return false;
            }
        }
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        dp = new Boolean[s3.length() + 1][s1.length() + 1][s2.length() + 1];
        dp[0][0][0] = true;
        
        return dpHelper(s1, s2, s3, s3.length(), s1.length(), s2.length());
    }

    private boolean dpHelper(String s1, String s2, String s3, int i, int p1, int p2) {
        if (p1 == p2 && p1 == 0) {
            return true;
        }
        if (dp[i][p1][p2] != null) {
            return dp[i][p1][p2];
        }
        if (p1 == 0) {
            return s2.charAt(p2 - 1) == s3.charAt(i - 1) && dpHelper(s1, s2, s3, i - 1, p1, p2 - 1);
        }
        if (p2 == 0) {
            return s1.charAt(p1 - 1) == s3.charAt(i - 1) && dpHelper(s1, s2, s3, i - 1, p1 - 1, p2);
        }

        boolean res = (s3.charAt(i - 1) == s1.charAt(p1 - 1) && dpHelper(s1, s2, s3, i - 1, p1 - 1, p2))
            || (s3.charAt(i - 1) == s2.charAt(p2 - 1) && dpHelper(s1, s2, s3, i - 1, p1, p2 - 1));

        dp[i][p1][p2] = res;
        return res;
    }
}


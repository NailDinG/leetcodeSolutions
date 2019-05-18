/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class Solution {
    private Boolean[][] mem;
    public boolean isMatch(String s, String p) {
        mem = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (mem[i][j] != null) {
            return mem[i][j];
        }
        // compare to the last of two string
        boolean ans;
        if (j == p.length()) {
            ans = i == s.length();
        } else {
            boolean firstmatch = (i < s.length() 
                && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
            if (j+1 < p.length() && p.charAt(j+1) == '*') {
                ans = (isMatch(s, p, i, j + 2)
                    || firstmatch && isMatch(s, p, i + 1, j));
            } else {
                ans = firstmatch && isMatch(s, p, i + 1, j + 1);
            }
        }
        mem[i][j] = ans;
        return ans;
    }
}


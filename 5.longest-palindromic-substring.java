/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {

    private int begin, maxlen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i ++ ) {
            findLongestPalindrome(s, i, i);
            findLongestPalindrome(s, i, i+1);
        }
        return s.substring(begin, begin + maxlen);
    }

    private void findLongestPalindrome(String s, int i, int j) {
        while (i >= 0 && j <= s.length()-1 && s.charAt(i) == s.charAt(j)) {
            i--;j++;
        }
        if (maxlen < j - i - 1) {
            maxlen = j - i - 1;
            begin = i + 1;
        }
    }
}


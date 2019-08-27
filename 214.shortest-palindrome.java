/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 */
class Solution {
    public String shortestPalindrome(String s) {
        int l = s.length();
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < l; i ++) {
            if (s.substring(0, l - i).equals(r.substring(i))) {
                return r.substring(0, i) + s;
            }
        }
        return "";
    }
}


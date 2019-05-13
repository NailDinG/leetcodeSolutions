/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j && i < s.length && j > 0) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;j--;
        }
    }
}


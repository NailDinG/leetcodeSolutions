/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] sArr = s.trim().split(" ");
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (sArr[i] == null || sArr[i].length() == 0) {
                continue;
            }
            sb.append(sArr[i]);
            sb.append(" ");
        } 
        return sb.toString().trim();
    }
}


import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(s, 0, new ArrayList<String>());
        return res;
    }

    private void helper(String s, int start, List<String> tmpList) {
        if (s.length() == start) {
            res.add(new ArrayList<>(tmpList));
        } else {
            for(int i = start; i < s.length(); i ++) {
                if (isPalindrome(s, start, i)) {
                    tmpList.add(s.substring(start, i + 1));
                    helper(s, i + 1, tmpList);
                    tmpList.remove(tmpList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}


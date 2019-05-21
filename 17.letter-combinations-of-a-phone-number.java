import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */
class Solution {

    private String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }
        if (digits.length() < 1) {
            return res;
        }
        for (int i = 0; i < digits.length(); i++) {
            letterCombinations(digits, i);
        }
        return res;
    }

    private void letterCombinations(String digits, int i) {
        String x = letters[digits.charAt(i) - '2'];
        if (i == 0) {
            for (int j = 0; j < x.length(); j++) {
                res.add("" + x.charAt(j));
            }
            return;
        }
        List<String> tmpList = new ArrayList<>();
        for (int j = 0; j < res.size(); j ++ ) {
            String tmp = res.get(j);
            for (int k = 0; k < x.length(); k ++) {
                tmpList.add(tmp + x.charAt(k));
            }
        }
        res = tmpList;
    }
}


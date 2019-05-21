import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return res;
        }
        if (n == 1) {
            res.add("()");
            return res;
        }
        generateParenthesis("", 0, 0, n);
        return res;
    }

    public void generateParenthesis(String p, int open, int close, int max) {
        if (p.length() == max * 2) {
            res.add(p);
            return;
        }
        if (open < max) {
            generateParenthesis(p + "(", open + 1, close, max);
        }
        if (close < open) {
            generateParenthesis(p + ")", open, close + 1, max);
        }
    }
}


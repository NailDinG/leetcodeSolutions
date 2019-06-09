import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */
class Solution {

    List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String cur = queue.poll();

            if (isValid(cur)) {
                res.add(cur);
                found = true;
            }

            if (found) {
                continue;
            }

            for (int i = 0; i < cur.length(); i ++) {
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') {
                    continue;
                }
                String t = cur.substring(0, i) + cur.substring(i + 1, cur.length());

                if (!visited.contains(t)) {
                    visited.add(t);
                    queue.add(t);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int stack = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') stack ++;
            if (s.charAt(i) == ')') {
                stack --;
                if (stack < 0) {
                    return false;
                }
            }
        }
        return stack == 0;
    }
}


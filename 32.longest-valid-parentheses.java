import java.util.Stack;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int[] record = new int[s.length()];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.add(i);
                record[i] = -1;
                continue;
            }
            if (arr[i] == ')' && !stack.isEmpty()) {
                int pos = stack.pop();
                record[pos] = 2;
            } else {
                record[i] = -2;
            }
        }
        int cur = 0;
        for (int i = 0; i< record.length; i++) {
            if (record[i] <= -1) {
                cur = 0;
                continue;
            }
            if (record[i] == 2) {
                cur += 2;
                if (cur > max) {
                    max = cur;
                }
            }
        }

        return max;
    }
}


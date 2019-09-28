import java.util.Stack;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */
class Solution {
    public int calculate(String s) {
        int len = s.length();
        int result = 0;
        int sign = 1;
        Stack<Integer> stackDi = new Stack<>();
        for (int i = 0; i < len; i ++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + (s.charAt(i + 1) - '0');
                    i ++;
                }
                stackDi.push(sign);
                stackDi.push(sum);
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                int sum = 0;
                char op = s.charAt(i);
                while (s.charAt(i + 1) == ' ') {
                    i ++;
                }
                // get next int
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + (s.charAt(i + 1) - '0');
                    i ++;
                }
                int num = stackDi.pop();
                stackDi.push(op == '*' ? num * sum : num / sum);
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            }
        }

        while (!stackDi.isEmpty()) {
            result += stackDi.pop() * stackDi.pop();
        }

        return result;
    }
}


import java.util.Stack;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                int tmp = twoNumsCal(a, b, tokens[i]);
                stack.push(tmp);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return 0;
    }

    private boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") 
            || operator.equals("*") || operator.equals("/");
    }

    private int twoNumsCal(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}


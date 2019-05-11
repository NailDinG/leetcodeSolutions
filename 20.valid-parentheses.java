import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
                stack.add(arr[i]);
                continue;
            }
            if (arr[i] == '}'|| arr[i] == ']' || arr[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char cur = stack.pop();
                if (cur == '(' && arr[i] == ')') {
                    continue;
                } else if (cur == '[' && arr[i] == ']') {
                    continue;
                } else if (cur == '{' && arr[i] == '}') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}


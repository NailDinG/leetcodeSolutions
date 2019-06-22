import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */
class Solution {
    public String decodeString(String s) {
        if (s == null) {
            return "";
        }
        char[] sArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c: sArr) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String tmpString = sb.toString();
                stack.pop();
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int cnt = Integer.parseInt(sb.toString());
                while(cnt > 0) {
                    for (char t: tmpString.toCharArray()) {
                        stack.push(t);
                    }
                    cnt --;
                }
            }
        }
        StringBuilder resSb = new StringBuilder();
        while (!stack.isEmpty()) {
            resSb.insert(0, stack.pop());
        }
        return resSb.toString();

    }
}


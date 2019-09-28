import java.util.Stack;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        Stack<Integer> nums = new Stack<>();
        // deal with ( and )
        int sign = 1;
        for (int i = 0; i < s.length(); i ++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                i ++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sum =  sum * 10 + (s.charAt(i) - '0');
                    i ++;
                }
                i --;
                result += sum * sign;
            }else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                nums.push(result);
                nums.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * nums.pop() + nums.pop();
            }
        }
        return result;
    }
}


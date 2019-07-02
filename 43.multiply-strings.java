/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int maxBytes = n1 + n2;
        int[] mem = new int[maxBytes];
        
        for (int i = n1 -1; i >= 0; i --) {
            for (int j = n2 - 1; j >= 0; j --) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = a * b + mem[p2];
                mem[p1] += (sum / 10);
                mem[p2] = (sum % 10);
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean firstByte = true;
        for (int i = 0; i < maxBytes; i ++) {
            if (firstByte && mem[i] == 0) {
                continue;
            } else {
                firstByte = false;
                sb.append(mem[i]);
            }
        }
        return sb.toString();
    }
}


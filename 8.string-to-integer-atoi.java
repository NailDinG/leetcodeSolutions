/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] strArr = str.trim().toCharArray();
        if (strArr == null || strArr.length == 0) {
            return 0;
        }

        if (!isNumeric(strArr[0]) && !isOperator(strArr[0])) {
            return 0;
        } else {
            boolean negative = false;
            boolean hasOp = false;
            int n = 0;
            while (n < strArr.length && strArr[n] == '+' ) {
                if (hasOp) {
                    return 0;
                }
                n++; hasOp = true;
                if (n >= strArr.length) {
                    return 0;
                }
            }
            if (strArr[n] == '-') {
                negative = true; n++;
                if (hasOp) {
                    return 0;
                }
            }
            if (n >= strArr.length) {
                return 0;
            }
            while (n < strArr.length && strArr[n] == '0') {
                n++;
                if (n >= strArr.length) {
                    return 0;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = n; i < strArr.length; i++) {
                if (isNumeric(strArr[i])) {
                    if (i - n >= 10 && negative) {
                        return Integer.MIN_VALUE;
                    }
                    if (i - n >= 10 && !negative) {
                        return Integer.MAX_VALUE;
                    }
                    sb.append(strArr[i]);
                } else {
                    break;
                }
            }
            if (sb.toString().length() == 0) {
                return 0;
            }
            char[] num = sb.toString().toCharArray();
            if (negative && num.length == 10) {
                char[] minInt = String.valueOf(Integer.MIN_VALUE).toCharArray();
                for (int i = 0; i < 10; i ++) {
                    if (minInt[i+1] > num[i]) {
                        break;
                    }
                    if (minInt[i+1] < num[i]) {
                        return Integer.MIN_VALUE;
                    }
                }
                return Integer.valueOf((negative ? "-" : "") + sb.toString());
            } else if (num.length == 10) {
                char[] maxInt = (String.valueOf(Integer.MAX_VALUE)).toCharArray();
                for (int i = 0; i < 10; i ++) {
                    if (maxInt[i] > num[i]) {
                        break;
                    }
                    if (maxInt[i] < num[i]) {
                        return Integer.MAX_VALUE;
                    }
                }
                return Integer.valueOf((negative ? "-" : "") + sb.toString());
            } else {
                return Integer.valueOf((negative ? "-" : "") + sb.toString());
            }
        }
    }

    private boolean isNumeric(char c) {
        return (int)c >= (int)'0' && (int)c <= (int)'9';
    }

    private boolean isOperator(char c) {
        return c == '-' || c == '+';
    }
}


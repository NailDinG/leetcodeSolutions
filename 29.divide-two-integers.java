/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */
class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        if (divisor == 0) {
            return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        long res = helper(Math.abs((long)dividend), Math.abs((long)divisor));

        if (res > Integer.MAX_VALUE) {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return ((int) res * sign);
        }

    }

    private long helper(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }

        long multiple = 1;
        long sum = divisor;

        while (sum + sum <= dividend) {
            sum += sum;
            multiple += multiple;
        }

        return multiple + helper(dividend - sum, divisor);
    }
}


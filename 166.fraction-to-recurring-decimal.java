import java.util.HashMap;

/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }
        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(num / den));
        if (num % den == 0L) {
            return sb.toString();
        }
        long remainder = (num % den) * 10; // 进位接着做除法
        sb.append(".");
        HashMap<Long, Integer> mem = new HashMap<>();

        while (remainder != 0L) {
            if (mem.containsKey(remainder)) {
                int repeat = mem.get(remainder);
                sb.insert(repeat, "(");
                sb.append(")");
                return sb.toString();
            }
            mem.put(remainder, sb.length());
            sb.append(String.valueOf(remainder / den));
            remainder = (remainder % den) * 10;
        }
        return sb.toString();


    }
}


import java.util.HashMap;

/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */
class Solution {
    HashMap<Integer, Double> mem = new HashMap<>();
    public double myPow(double x, int n) {
        double res = 0;
        if (n < 0 && n != Integer.MIN_VALUE) {
            n = -n;
            x = 1 / x;
        }
        if (n == Integer.MIN_VALUE) {
            double tmp = myPow(x, n / 2);
            return tmp * tmp;
        }
        if (n == 0) {
            return 1;
        } else {
            if (n == 1) {
                return x;
            } else if (n == 2) {
                return x * x;
            }
            if (mem.containsKey(n)) {
                return mem.get(n);
            }
            double tmp = myPow(x, n / 2);
            if (n % 2 == 0) {
                res = tmp * tmp;
            } else {
                res = x * tmp * tmp;
            }
            mem.put(n, res);

            return res;
        }
    }
}


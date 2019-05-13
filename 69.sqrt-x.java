/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */
class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x < 2) {
            return x;
        }
        int i = 0;
        int j = x;
        int mid = i + (j - i) / 2;

        while (i <= j) {
            if (mid < x / mid) {
                i = mid + 1;
            } else if (mid > x / mid) {
                j = mid - 1;
            } else {
                return mid;
            }
            mid = i + (j - i) / 2;
        }
        return j;
    }
}


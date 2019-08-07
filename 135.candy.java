/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int[] left2right = new int[n];
        int[] right2left = new int[n];
        left2right[0] = 1;
        right2left[n - 1] = 1;
        for (int i = 1; i < n; i ++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            } else {
                left2right[i] = 1;
            }

            if (ratings[n - i - 1] > ratings[n - i]) {
                right2left[n - i - 1] = right2left[n - i] + 1;
            } else {
                right2left[n - i - 1] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i ++) {
            res += Math.max(left2right[i], right2left[i]);
        }
        return res;

    }
}


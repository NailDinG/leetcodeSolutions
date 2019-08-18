/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int bw = 0;
        int ew = 0;
        int res = 0;
        int curSum = 0;
        while (bw <= ew && ew < nums.length) {
            curSum += nums[ew];
            if (curSum < s) {
                ew ++;
            } else {
                res = res <= 0 ? ew - bw + 1 : Math.min(ew - bw + 1, res);
                curSum -= nums[bw];
                curSum -= nums[ew];
                bw ++;
            }
        }
        return res;
    }
}


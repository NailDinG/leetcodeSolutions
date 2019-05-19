/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 * 
 * dp(i, j) = max(dp(i, j - 1), dp(i + 1, j), multi(i, j))
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0]; int min = nums[0]; int res = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            int preMax = max, preMin = min;
            max = Math.max(Math.max(preMax * nums[i], nums[i]), preMin * nums[i]);
            min = Math.min(Math.min(preMax * nums[i], nums[i]), preMin * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}


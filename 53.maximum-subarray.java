/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {

    public int maxSubArray(int[] nums) {
        int last = nums[0];
        int max = last;

        for (int i = 1; i < nums.length; i ++) {
            last = Math.max(last + nums[i], nums[i]);
            max = Math.max(max, last);
        }

        return max;
    }
}


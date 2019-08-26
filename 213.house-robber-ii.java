/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return Math.max(0, nums[0]);
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        int preNo = 0, preYes = 0;
        for (int i = lo; i <= hi; i ++) {
            int tmp = preYes;
            preYes = preNo + nums[i];
            preNo = Math.max(tmp, preNo);
        }
        return Math.max(preNo, preYes);
    }
}


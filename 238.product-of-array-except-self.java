/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i ++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; i --) {
            res[i] = res[i] * right;
            right = nums[i] * right;
        }
        return res;
    }
}


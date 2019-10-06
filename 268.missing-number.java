/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */
class Solution {
    // method 1
    public int xorMethod(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            res = res ^ i;
            res = res ^ nums[i];
        }
        return res;
    }
    // method 2
    public int sumMethod(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i ++) {
            sum -= nums[i];
        }
        return sum;
    }
}


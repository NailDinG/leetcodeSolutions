/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */
class Solution {
    public int singleNumber(int[] nums) {
        int bitLow = 0;
        int bitHigh = 0;
        for (int i = 0; i < nums.length; i ++) {
            bitLow = bitLow ^ nums[i] & ~bitHigh;
            bitHigh = bitHigh ^ nums[i] & ~bitLow;
        }
        return bitLow;
    }
}


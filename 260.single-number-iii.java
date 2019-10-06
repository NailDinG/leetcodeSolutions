/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }
        int xOR = nums[0];
        // get the result of a ^ a ^ b ^ c = b ^ c
        for (int i = 1; i < nums.length; i ++) {
            xOR = xOR ^ nums[i];
        }
        int firstBit = findFirstOneBit(xOR);

        int a = 0;
        for (int i = 0; i < nums.length; i ++) {
            if ((firstBit & nums[i]) != 0) {
                a = a ^ nums[i];
            }
        }
        int b = a ^ xOR;
        return new int[]{a, b};
    }

    private int findFirstOneBit(int xOR) {
        return xOR & ~(xOR - 1);
    }
}


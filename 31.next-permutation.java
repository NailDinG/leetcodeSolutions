/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 * 
 * 这个题思路很难想到，思路可以参照leetcode官网给出的解法
 * https://leetcode.com/problems/next-permutation/solution/
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        // find the first descend num
        while (i >= 0 && nums[i + 1] <= nums[i] ) {
            i -- ;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int k = i + 1;
        int n = nums.length - 1;
        while (k < n) {
            int tmp = nums[k];
            nums[k] = nums[n];
            nums[n] = tmp;
            k ++; n --;
        }
        return;
    }
}


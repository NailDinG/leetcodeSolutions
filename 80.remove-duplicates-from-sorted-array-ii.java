/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }
        int lastNum = nums[0];
        int lastCount = 1;
        int p = 1;
        count ++;
        
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == lastNum) {
                lastCount ++;
                if (lastCount <= 2) {
                    nums[p] = nums[i];
                    count ++;
                    p ++;
                }
            } else {
                // move i to p
                nums[p] = nums[i];
                lastCount = 1;
                count ++;
                lastNum = nums[i];
                p ++;
            }
            i ++;
        }

        return count;
    }
}


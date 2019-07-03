/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *  贪心算法
 */
class Solution {
    public int jump(int[] nums) {
        int res = 0;
        int curPos = 0;
        int nexPos = 0;
        int maxDistance = 0;
        if (nums.length == 1) {
            return 0;
        }
        while (curPos < nums.length) {
            int distance = nums[curPos];
            if (curPos + distance >= nums.length - 1) {
                return res + 1;
            }
            for (int i = 1; i <= distance; i ++) {
                int totalDist = nums[curPos + i] + i;
                if (totalDist >= maxDistance && nums[curPos + i] > 0) {
                    maxDistance = totalDist;
                    nexPos = curPos + i;
                }
            }
            res ++;
            curPos = nexPos;
            maxDistance = 0;
        }
        return res;
    }
}


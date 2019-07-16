import java.util.HashMap;

/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */
class Solution {

    HashMap<Integer, Boolean> mem = new HashMap<>();
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int maxPos = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i > maxPos) return false;
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return true;
    }
}


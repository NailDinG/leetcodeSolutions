import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=473 lang=java
 *
 * [473] Matchsticks to Square
 */
class Solution {

    int[] sums = new int[4];
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i ++) {
            int t = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = t;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length ; i ++) {
            sum += nums[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        int line  = sum / 4;
        if (nums[nums.length - 1] > line) {
            return false;
        }
        return dfs(nums, 0, line);
    }

    private boolean dfs(int[] nums, int index, int line) {
        if (index == nums.length) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }
        int cur = nums[index];

        for (int i = 0; i < 4; i ++) {
            if (sums[i] + cur <= line) {
                sums[i] += cur;
                if (dfs(nums, index + 1, line)) {
                    return true;
                }
                sums[i] -= cur;
            }
        }
        return false;
    }
}


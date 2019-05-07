import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && nums[i] == nums[i-1] && i < nums.length - 2) {
                i++;
            }
            int s = i+1;
            int e = nums.length - 1;
            while (s < e && e > i + 1 && s < nums.length - 1) {
                int tmp = nums[i] + nums[s] + nums[e];
                int distance = target - tmp;
                if (distance > 0) { //偏小
                    s++;
                } else if (distance < 0) {
                    e--;
                } else {
                    return tmp;
                }
                if (Math.abs(target - tmp) < minDistance) {
                    res = tmp;
                    minDistance = Math.abs(target - tmp);
                }
            }
        }
        return res;
    }
}


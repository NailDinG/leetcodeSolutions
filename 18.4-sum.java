import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i ++) {
            while (i > 0 && i < nums.length - 3 && nums[i] == nums[i - 1]) {
                i ++;
            }
            for (int j = i + 1; j < nums.length - 2; j ++) {
                while (j > i + 1 && j < nums.length - 2 && nums[j] == nums[j - 1]) {
                    j ++;
                }
                int s = j + 1;
                int e = nums.length - 1;
                while (s < e) {
                    int sum = nums[i] + nums[j] + nums[s] + nums[e];
                    if (sum < target) {
                        while (s + 1 < e && nums[s + 1] == nums[s]) {
                            s ++;
                        }
                        s ++;
                    } else if (sum > target) {
                        while (e - 1 > s && nums[e - 1] == nums[e]) {
                            e --;
                        }
                        e --;
                    } else {
                        // 放入结果
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[s]);
                        tmp.add(nums[e]);
                        res.add(tmp);
                        while (s + 1 < e && nums[s + 1] == nums[s]) {
                            s ++;
                        }
                        while (e - 1 > s && nums[e - 1] == nums[e]) {
                            e --;
                        }
                        s ++; e --;
                    }   
                }
            }
        }
        return res;
    }
}


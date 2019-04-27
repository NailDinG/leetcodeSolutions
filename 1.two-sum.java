import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        Map<Integer, Integer> recordMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!recordMap.containsKey(nums[i])) {
                recordMap.put(nums[i], i);
            }
            if (recordMap.containsKey(target - nums[i]) && recordMap.get(target - nums[i]) != i) {
                result[0] = recordMap.get(target - nums[i]);
                result[1] = i;
                break;
            }
        }
        return result;
    }
}


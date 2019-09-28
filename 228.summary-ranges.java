import java.util.*;

/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(String.valueOf(nums[0]));
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] - nums[i - 1] == 1) {
                if (i == nums.length - 1) {
                    // submit last continuous range
                    String tmp = result.get(result.size() - 1) + "->" + String.valueOf(nums[i]);
                    result.set(result.size() - 1, tmp);
                }
                continue;
            } else {
                // submit last continuous range
                if (!String.valueOf(nums[i - 1]).equals(result.get(result.size() - 1))) {
                    String tmp = result.get(result.size() - 1) + "->" + String.valueOf(nums[i - 1]);
                    result.set(result.size() - 1, tmp);
                }
                // go to another continuous range
                result.add(String.valueOf(nums[i]));
            }
        }

        return result;
    }
}


import java.util.HashSet;

/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        int poCnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                poCnt++;
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                }
                if (min > nums[i]) {
                    min = nums[i];
                }
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
        }
        if (min > 1) {
            return 1;
        } else {
            for (int i = 2; i <= max; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }
        }
        return max + 1;
    }
}


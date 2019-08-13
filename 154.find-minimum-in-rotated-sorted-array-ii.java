/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */
class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[end]) {
                return Math.min(nums[start], min);
            } else if (nums[start] > nums[end]) {
                min = Math.min(min, nums[end]);
                if (nums[mid] >= nums[start]) {
                    min = Math.min(min, nums[end]);
                    start = mid + 1;
                } else {
                    min = Math.min(min, nums[mid]);
                    start ++;
                    end = mid;
                }
            } else {
                if (nums[0] == nums[start] && nums[len - 1] == nums[end]) {
                    if (nums[mid] < nums[start]) {
                        min = Math.min(min, nums[mid]);
                        end = mid - 1;
                    } else if (nums[mid] > nums[start]){
                        min = Math.min(nums[start], min);
                        start = mid + 1;
                        end = end - 1;
                    } else {
                        min = Math.min(nums[start], min);
                        start ++;
                        end --;
                    }
                } else {
                    return Math.min(nums[start], min);
                }
            }
        }
        return min;
    }
}


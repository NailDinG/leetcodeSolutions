/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
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
                return nums[start];
            } else if (nums[start] > nums[end]) {
                min = Math.min(min, nums[end]);
                if (nums[mid] > nums[start]) {
                    min = Math.min(min, nums[end]);
                    start = mid + 1;
                } else {
                    min = Math.min(min, nums[mid]);
                    start ++;
                    end = mid;
                }
            } else {
                return nums[mid];
            }
        }
        return min;
    }
}


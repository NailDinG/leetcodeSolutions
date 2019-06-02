/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        int smallest = 0;
        // find the num which smallest
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[begin] <= nums[mid]) {
                if (target >= nums[begin] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        
        }
        return nums[begin] == target ? begin : -1;
    }
}


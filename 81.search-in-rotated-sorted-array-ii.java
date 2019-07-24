/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return target == nums[0];
        }
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            //System.out.println(begin + " " + mid + " " + end);
            if (nums[mid] == target) {
                return true;
            }

            // 左侧顺序是乱的，但右边是正序的
            if (nums[mid] < nums[end] || nums[mid] < nums[begin]) {
                // 判断是否在右边，如果不在右边就在左边
                if (nums[mid] < target && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            // 左侧正序，右侧乱序
            } else if (nums[mid] > nums[end] || nums[mid] > nums[begin]) {
                // 判断是否在左边，如果不在左边就在右边
                if (nums[mid] > target && target >= nums[begin]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            // 只有在nums[begin] == nums[mid] == nums[end]的时候才会到这里
            } else {
                end --;
            }
        }

        return false;
        
    }
}


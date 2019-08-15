/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return null;
        }
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int cur = numbers[start] + numbers[end];
            if (cur == target) {
                return new int[]{start + 1, end + 1};
            } else if (cur > target) {
                end --;
            } else {
                start ++;
            }
        }
        return null;
    }
}


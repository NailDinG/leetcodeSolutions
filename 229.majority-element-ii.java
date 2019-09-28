import java.util.*;
/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int num1 = nums[0], num2 = nums[0], cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == num1) {
                cnt1 ++;
            } else if (nums[i] == num2) {
                cnt2 ++;
            } else if (cnt1 == 0) {
                num1 = nums[i]; cnt1 ++;
            } else if (cnt2 == 0) {
                num2 = nums[i]; cnt2 ++;
            } else {
                cnt1 --;
                cnt2 --;
            }
        }

        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == num1) {
                cnt1 ++;
            } else if (nums[i] == num2) {
                cnt2 ++;
            }
        }
        if (cnt1 > nums.length / 3) {
            result.add(num1);
        }
        if (cnt2 > nums.length / 3) {
            result.add(num2);
        }

        return result;
    }
}


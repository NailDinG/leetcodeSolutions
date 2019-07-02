/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
class Solution {
    public int trap(int[] height) {
        int water = 0;
        if (height.length == 0) {
            return water;
        }
        
        int start = 0;
        int end = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;

        while (start < end) {
            if (height[start] < height[end]) {
                if (height[start] > leftmax) {
                    leftmax = height[start];
                } else {
                    water += (leftmax - height[start]);
                }
                start ++;
            } else {
                if (height[end] > rightmax) {
                    rightmax = height[end];
                } else {
                    water += (rightmax - height[end]);
                }
                end --;
            }
        }
        return water;
    }
}



/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */
class Solution {
    public int maxArea(int[] height) {
        int before = 0;
        int end = height.length - 1;
        int max = 0;
        while (before < end && before < height.length && end > 0) {
            int tmp = (end - before) * Math.min(height[before], height[end]);
            max = Math.max(tmp, max);
            if (height[before] > height[end]) {
                end -- ;
            } else {
                before ++ ;
            }
        }
        return max;
    }
}


/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */
class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int index = 0;

        while (index <= blue) {
            if (nums[index] == 0) {
                nums[index] = nums[red];
                nums[red] = 0;
                red ++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[blue];
                nums[blue] = 2;
                blue --;
                index --;
            }
            index ++;
        }
    }
}


/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 * 
 * todo some review
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    private int findKth(int[] nums1, int nums1Begin, int[] nums2, int nums2Begin, int k) {
        if (nums1Begin >= nums1.length) {
            return nums2[nums2Begin + k - 1];
        }
        if (nums2Begin >= nums2.length) {
            return nums1[nums1Begin + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[nums1Begin], nums2[nums2Begin]);
        }

        int midVal1 = (nums1Begin + k / 2 - 1 < nums1.length) ?
                nums1[nums1Begin + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (nums2Begin + k / 2 - 1 < nums2.length) ?
                nums2[nums2Begin + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (midVal1 < midVal2) {
            return findKth(nums1, nums1Begin + k / 2, nums2, nums2Begin, k - k / 2);
        } else {
            return findKth(nums1, nums1Begin, nums2, nums2Begin + k / 2, k - k / 2);
        }
    }
}


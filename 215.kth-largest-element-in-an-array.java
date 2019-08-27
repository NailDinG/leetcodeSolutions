import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a, b) -> {
            return a - b;
        });
        for (int i = 0; i < nums.length; i ++) {
            if (pQueue.size() < k) {
                pQueue.add(nums[i]);
            } else {
                if (nums[i] > pQueue.peek()) {
                    pQueue.remove();
                    pQueue.add(nums[i]);
                }
            }
        }
        return pQueue.remove();
    }
}


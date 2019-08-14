/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
        int bucketNum = 1 + (max - min) / bucketSize;

        Bucket[] buckets = new Bucket[bucketNum];

        for (int i = 0; i < bucketNum; i ++) {
            buckets[i] = new Bucket(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        for (int i = 0; i < nums.length; i ++) {
            int idx = (nums[i] - min) / bucketSize;
            buckets[idx].isUsed = true;
            buckets[idx].minVal = Math.min(buckets[idx].minVal, nums[i]);
            buckets[idx].maxVal = Math.max(buckets[idx].maxVal, nums[i]);
        }

        int res = 0;
        int lastMax = min;
        for (Bucket bucket : buckets) {
            if (bucket.isUsed) {
                res = Math.max(res, bucket.minVal - lastMax);
                lastMax = bucket.maxVal;
            }
        }
        return res;
    }
}

class Bucket {
    int minVal;
    int maxVal;
    boolean isUsed;
    public Bucket(int minVal, int maxVal) {
        this.minVal = minVal;
        this.maxVal = maxVal;
    }
}


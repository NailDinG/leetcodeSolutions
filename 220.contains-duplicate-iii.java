import java.util.*;

/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 * abs(nums[i] - nums[j]) <= t while abs(i - j) <= k
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        Map<Long, Long> bucketMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (bucketMap.containsKey(bucket) 
                || (bucketMap.containsKey(bucket - 1) && remappedNum - bucketMap.get(bucket - 1) <= t) 
                || (bucketMap.containsKey(bucket + 1) && bucketMap.get(bucket + 1) - remappedNum <= t)) {
                return true;
            }
            if (bucketMap.size() >= k) {
                long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                bucketMap.remove(lastBucket);
            }
            bucketMap.put(bucket, remappedNum);
        }
        return false;
    }
}


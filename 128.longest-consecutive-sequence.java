import java.util.HashSet;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> mem = new HashSet<>();

        for (int num : nums) {
            mem.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!mem.contains(num - 1)) {
                int curLen = 1;
                int curNum = num;

                while (mem.contains(curNum + 1)) {
                    curNum += 1;
                    curLen ++;
                }

                res = Math.max(curLen, res);
            }

        }
        return res;
    }
}


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int lastEnd = Integer.MIN_VALUE; 
        for (int[] interval : intervals) {
            if (list.size() == 0) {
                list.add(interval);
                lastEnd = interval[1];
            } else {
                // merge
                if (interval[0] <= lastEnd) {
                    list.get(list.size() - 1)[1] = Math.max(interval[1], lastEnd);
                    lastEnd = Math.max(interval[1], lastEnd);

                } else {
                    list.add(interval);
                    lastEnd = interval[1];
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i ++) {
            res[i] = list.get(i);
        }
        return res;
    }
}


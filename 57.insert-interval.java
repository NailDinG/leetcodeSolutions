import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        List<int[]> list = new ArrayList<>();
        int index = 0;
        while (index < intervals.length && newInterval[0] > intervals[index][1]) {
            list.add(intervals[index]);
            index ++;
        }
        while (index < intervals.length && (newInterval[1] >= intervals[index][0])) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index ++;
        }
        list.add(newInterval);
        while (index < intervals.length) {
            list.add(intervals[index]);
            index ++;
        }
        return list.toArray(new int[list.size()][]);
    }
}


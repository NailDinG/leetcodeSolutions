import java.util.ArrayList;

/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null ) {
            return -1;
        }
        if (gas.length != cost.length) {
            return -1;
        }
        if (gas.length == 1 && gas[0] >= cost[0]) {
            return 0;
        }
        for (int i = 0; i < gas.length; i ++) {
            if (gas[i] - cost[i] >= 0) {
                int res = canCompleteCircuit(gas, cost, i);
                if (res > -1) {
                    return res;
                }
            }
        }
        return -1;
    }

    private int canCompleteCircuit(int[] gas, int[] cost, int start) {
        int distance = gas.length;
        int gasRemain = 0;
        for (int i = 0; i < distance; i ++) {
            int curPos = (start + i) % distance;
            if (gasRemain + gas[curPos] < cost[curPos]) {
                return -1;
            } else {
                gasRemain = gasRemain + gas[curPos] - cost[curPos];
            }
        }
        return start;
    }
}


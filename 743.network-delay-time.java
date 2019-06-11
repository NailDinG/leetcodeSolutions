import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */
class Solution {


    HashMap<Integer, HashMap<Integer, Integer>> ajMap = new HashMap<>();

    public int networkDelayTime(int[][] times, int N, int K) {
        for (int[] time : times) {
            if (!ajMap.containsKey(time[0])) {
                HashMap<Integer, Integer> tmp = new HashMap<>();
                tmp.put(time[1], time[2]);
                ajMap.put(time[0], tmp);
            } else {
                ajMap.get(time[0]).put(time[1], time[2]);
            }
        }
        if (!ajMap.containsKey(K)) {
            return -1;
        }
        int[] nums = new int[N + 1];
        Arrays.fill(nums, -1);
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((info1, info2) -> info1[0] - info2[0]);
        queue.offer(new int[]{0, K});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dis = cur[0];
            int pos = cur[1];
            if (nums[pos] != -1) {
                continue;
            }
            nums[pos] = dis;
            if (ajMap.containsKey(pos)) {
                HashMap<Integer, Integer> tmp = ajMap.get(pos);
                for (Integer key : tmp.keySet()) {
                    if (nums[key] == -1) {
                        queue.offer(new int[]{nums[pos] + tmp.get(key), key});
                    }
                }
            }
        }
        int res = -1;
        for (int i = 1; i < N + 1; i ++) {
            if (nums[i] == -1) {
                return -1;
            }
            if (nums[i] > -1 && nums[i] > res) {
                res = nums[i];
            }
        }
        return res;
    }
}


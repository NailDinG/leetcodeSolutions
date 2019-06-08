import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */
class Solution {
    // 邻接矩阵 
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }

        List<Set<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i ++) {
            graph.add(new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i ++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i = 0; i < leaves.size(); i ++) {
                int point = leaves.get(i);
                int j = graph.get(point).iterator().next();
                graph.get(j).remove(point);
                if (graph.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}


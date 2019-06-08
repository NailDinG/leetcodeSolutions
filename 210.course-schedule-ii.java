import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> resList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] degree = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i ++) {
            degree[prerequisites[i][0]] ++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int count = 0;
        for (int i = 0; i < numCourses; i ++) {
            if (degree[i] == 0) {
                queue.add(i);
                resList.add(i);
                count ++;
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int)graph[course].get(i);
                degree[pointer] --;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                    resList.add(pointer);
                    count ++;
                }
            }
        }
        int[] res = new int[resList.size()];

        if (count != numCourses) {
            return new int[0];
        }
        for (int i = 0; i < resList.size(); i ++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}


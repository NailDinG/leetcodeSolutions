import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i ++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i ++) {
            degree[prerequisites[i][0]] ++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int count = 0;
        for (int i = 0; i < degree.length; i ++) {
            if (degree[i] == 0) {
                count ++;
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            for (int i = 0; i < graph[course].size(); i ++) {
                int pointer = (int)graph[course].get(i);
                degree[pointer] --;
                if (degree[pointer] == 0) {
                    count ++;
                    queue.add(pointer);
                }
            }
        }

        return count == numCourses;
    }
}


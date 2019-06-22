import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */
class Solution {

    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    HashSet<String> place = new HashSet<>();
    List<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return res;
        }
        
        // 邻接表
        for (List<String> ticket: tickets) {
            if (ticket.size() != 2) {
                continue;
            }
            String from = ticket.get(0);
            String to = ticket.get(1);
            place.add(to);
            if (!map.containsKey(from)) {
                PriorityQueue<String> tmpList = new PriorityQueue<String>();
                tmpList.add(to);
                map.put(from, tmpList);
            } else {
                map.get(from).add(to);
            }
        }

        dfs("JFK");
        return res;
    }

    private void dfs(String from) {
        if (from == null || from == "") {
            return;
        } 
        while (map.containsKey(from) && !map.get(from).isEmpty()) {
            dfs(map.get(from).poll());
        }
        res.add(0, from);
    }
}


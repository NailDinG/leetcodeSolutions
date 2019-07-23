import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */
class Solution {

    class Pair{
        char c;
        int pos;
        Pair(char c, int pos) {
            this.c = c;
            this.pos = pos;
        }
    }

    public String minWindow(String s, String t) {
        String res = "";
        if (s == null) {
            return res;
        }
        if (s.equals(t)) {
            return t;
        }
        HashMap<Character, Integer> mem = new HashMap<>();
        ArrayList<Pair> queue = new ArrayList<>();
        for (char c: t.toCharArray()) {
            if (mem.containsKey(c)) {
                mem.put(c, mem.get(c) + 1);
            } else {
                mem.put(c, 1);
            }
        }
        int total = t.length();

        int index = 0;
        char[] sArr = s.toCharArray();
        while (index < s.length()) {
            if (mem.containsKey(sArr[index])) {
                Pair tmp = new Pair(sArr[index], index);
                queue.add(tmp);
                //System.out.print(tmp.c);
                //System.out.print(index);
            }
            index ++;
        }
        
        int size = queue.size();
        //System.out.println(size);

        int start = 0;
        int end = 0;

        int min = Integer.MAX_VALUE;
        
        while (end < size) {
            mem.put(queue.get(end).c, mem.get(queue.get(end).c) - 1);

            //System.out.println(end);
            if (mem.get(queue.get(end).c) >= 0) {
                total --;  
            } 

            //System.out.println(mem.toString());
            if (total == 0) {
                while (mem.get(queue.get(start).c) < 0) {
                    mem.put(queue.get(start).c, mem.get(queue.get(start).c) + 1);
                    start ++; 
                }
                //System.out.println(queue.get(end).pos - queue.get(start).pos + 1);
                if (min > queue.get(end).pos - queue.get(start).pos + 1) {
                    min = queue.get(end).pos - queue.get(start).pos + 1;
                    res = s.substring(queue.get(start).pos, queue.get(end).pos + 1);
                }

                mem.put(queue.get(start).c, mem.get(queue.get(start).c) + 1);
                start ++;
                total ++;
            }
            end ++;
        }
        
        return res;
    }
}


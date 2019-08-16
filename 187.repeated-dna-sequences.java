import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }
        HashMap<String, Integer> mem = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i ++) {
            String cur = s.substring(i, i + 10);
            if (mem.containsKey(cur)) {
                mem.put(cur, mem.get(cur) + 1);
            } else {
                mem.put(cur, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : mem.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}


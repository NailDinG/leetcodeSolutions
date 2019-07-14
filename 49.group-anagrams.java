import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> mem = new HashMap<>();
        for (String str: strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            //System.out.println(key);
            if (mem.containsKey(key)) {
                res.get(mem.get(key)).add(str);
            } else {
                mem.put(key, res.size());
                List<String> l = new ArrayList<>();
                l.add(str);
                res.add(l);
            }
        }
        return res;
    }
}


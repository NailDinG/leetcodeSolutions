import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */
class Solution {
    HashSet<String> dict = null;
    HashMap<String, List<String>> mem = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<String>();
        for (String d : wordDict) {
            dict.add(d);
        }
        return helper(s);
    }

    private List<String> helper(String s) {
        List<String> res = new ArrayList<>();
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> subList = helper(s.substring(word.length()));

                for (String sub : subList) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        mem.put(s, res);
        return res;
    }
}

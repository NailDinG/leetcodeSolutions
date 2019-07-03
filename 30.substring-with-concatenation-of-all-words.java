import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> mem = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }
        for (String word : words) {
            mem.put(word, mem.getOrDefault(word, 0) + 1);
        }
        int flagLen = words[0].length();
        int strLen = s.length();
        int n = words.length;
        // 类似于产生一个窗口来判断和比较
        for (int i = 0; i <= strLen - n * flagLen; i ++) {
            String curWindows = s.substring(i, i + n * flagLen);
            boolean containAll = true;
            HashMap<String, Integer> record = new HashMap<>();
            record.putAll(mem);
            for (int j = 0; j < n; j ++) {
                String curFlag = curWindows.substring(j * flagLen, (j + 1) * flagLen);
                if (record.containsKey(curFlag) && record.get(curFlag) > 0) {
                    record.put(curFlag, record.get(curFlag) - 1);
                } else {
                    containAll = false;
                    break;
                }
            }
            if (containAll) {
                res.add(i);
            }
        }
        return res;
    }
}


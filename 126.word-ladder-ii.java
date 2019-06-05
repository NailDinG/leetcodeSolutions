import java.util.*;
/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */
class Solution {

    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> map;
    int min = Integer.MAX_VALUE;

    // Time limit Exceeded Solution
    // public List<List<String>> findLadders(String beginWord, String endWord,
    // List<String> wordList) {
    // ArrayList<String> tmpList = new ArrayList<>();
    // int tmp = 26;
    // for (int i = 1; i < beginWord.length(); i ++) {
    // tmp = tmp * 26;
    // }
    // minLength = tmp;
    // tmpList.add(beginWord);
    // findLadderSteps(beginWord, endWord, wordList, tmpList, new
    // HashSet<String>());
    // return res;
    // }

    // private void findLadderSteps(String beginWord, String endWord, List<String>
    // wordList, List<String> tmpList, HashSet<String> mem) {
    // if (beginWord.equals(endWord)) {
    // if (minLength > tmpList.size()) {
    // minLength = tmpList.size();
    // res = new ArrayList<>();
    // res.add(new ArrayList<String>(tmpList));
    // } else if (minLength == tmpList.size()) {
    // res.add(new ArrayList<String>(tmpList));
    // }
    // return;
    // }

    // for (int i = 0; i < wordList.size(); i ++) {
    // String cur = wordList.get(i);
    // if (!mem.contains(cur) && isNearby(beginWord, cur)) {
    // tmpList.add(cur);mem.add(cur);
    // findLadderSteps(cur, endWord, wordList, tmpList, mem);
    // tmpList.remove(tmpList.size() - 1);
    // mem.remove(cur);
    // }
    // }
    // }

    // private boolean isNearby(String a, String b) {
    // int distance = 0;
    // if (a.length() == b.length()) {
    // for (int i = 0; i < a.length(); i ++) {
    // if (a.charAt(i) != b.charAt(i)) {
    // distance ++;
    // if (distance > 1) {
    // return false;
    // }
    // }
    // }
    // return distance == 1;
    // }
    // return false;
    // }

    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     ArrayList<String> tmpList = new ArrayList<>();
    //     int tmp = 26;
    //     for (int i = 1; i < beginWord.length(); i++) {
    //         tmp = tmp * 26;
    //     }
    //     minLength = tmp;
    //     tmpList.add(beginWord);
    //     findLadderSteps(beginWord, endWord, wordList, tmpList, new HashSet<String>());
    //     return res;
    // }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return res;
        }
        Queue<String> queue = new ArrayDeque<String>();
        queue.add(beginWord);

        map = new HashMap<String, List<String>>(); // 邻接表
        Map<String, Integer> ladder = new HashMap<>();
        for (String string : wordList) {
            ladder.put(string, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        wordList.add(endWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if (step > min) {
                break;
            }

            for (int i = 0; i < word.length(); i ++) {
                StringBuilder sb = new StringBuilder(word);

                for (char ch = 'a'; ch <= 'z'; ch ++) {
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();

                    if (ladder.containsKey(newWord)) {
                        if (step > ladder.get(newWord)) {
                            continue;
                        } else if (step < ladder.get(newWord)) {
                            ladder.put(newWord, step);
                            queue.add(newWord);
                        }

                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(word);
                            map.put(newWord, list);
                        }

                        if (newWord.equals(endWord)) {
                            min = step;
                        }
                    }
                }
            }
        }
        backTrace(endWord, beginWord, new LinkedList<String>());
        return res;
    }

    private void backTrace(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                backTrace(s, start, list);
            }
        }
        list.remove(0);
    }
}

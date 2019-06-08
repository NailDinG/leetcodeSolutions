import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        // word's min distance from beginWord
        Map<String, Integer> ladder = new HashMap<>();
        for (int i = 0; i < wordList.size(); i ++) {
            ladder.put(wordList.get(i), Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 1);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            for (int i = 0; i < word.length(); i ++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c ++) {
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if (ladder.containsKey(newWord)) {
                        if (step > ladder.get(newWord)) {
                            continue;
                        } else if (step < ladder.get(newWord)) {
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        }

                        if (endWord.equals(newWord)) {
                            min = step;
                        }
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
    }
}


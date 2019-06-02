import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */
class Solution {

    List<List<String>> res = new ArrayList<>();
    int minLength = Integer.MAX_VALUE;

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

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ArrayList<String> tmpList = new ArrayList<>();
        int tmp = 26;
        for (int i = 1; i < beginWord.length(); i++) {
            tmp = tmp * 26;
        }
        minLength = tmp;
        tmpList.add(beginWord);
        findLadderSteps(beginWord, endWord, wordList, tmpList, new HashSet<String>());
        return res;
    }
}

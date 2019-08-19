/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */
class WordDictionary {

    /** node */
    class TrieNode {
        char val;
        boolean isEnd;
        TrieNode[] nexts;
        public TrieNode() {}
        public TrieNode(char _val, boolean _isEnd) {
            this.val = _val;
            this.isEnd = _isEnd;
            this.nexts = new TrieNode[26];
        }
    }

    private TrieNode root = null;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('-', false);
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            int curPos = c - 'a';
            if (cur.nexts[curPos] == null) {
                cur.nexts[curPos] = new TrieNode(c, i == word.length() - 1);
            }
            if (i == word.length() - 1) {
                cur.nexts[curPos].isEnd = true;
            }
            cur = cur.nexts[curPos];
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root;
        boolean[] ans = {false};
        search(word, 0, cur, ans);
        return ans[0];
    }

    private void search(String word, int idx, TrieNode curRoot, boolean[] ans) {
        if (curRoot == null) {
            return;
        }
        
        if (idx == word.length()) {
            if (curRoot.isEnd) {
                ans[0] = true;
            }
            return;
        }
        
        char c = word.charAt(idx);
        if (c != '.') {
            int pos = c - 'a';
            if (curRoot.nexts[pos] != null) {
                search(word, idx + 1, curRoot.nexts[pos], ans);
            } else {
                return;
            }
        } else {
            for (int i = 0; i < 26; i ++) {
                if (curRoot.nexts[i] != null) {
                    search(word, idx + 1, curRoot.nexts[i], ans);
                }
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


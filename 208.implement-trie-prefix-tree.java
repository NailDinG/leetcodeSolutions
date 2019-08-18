/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */
class Trie {

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
    public Trie() {
        root = new TrieNode('-', false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            int curPos = c - 'a';
            if (cur.nexts[curPos] == null) {
                return false;
            } else {
                if (i == word.length() - 1) {
                    return cur.nexts[curPos].isEnd;
                }
                cur = cur.nexts[curPos];
            }
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            int curPos = c - 'a';
            if (cur.nexts[curPos] == null) {
                return false;
            } else {
                cur = cur.nexts[curPos];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


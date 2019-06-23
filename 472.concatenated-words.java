import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 * Solution: Use tire tree
 */
class Solution {

    class Tire {
        Tire[] children;
        boolean isWord;

        Tire() {
            this.children = new Tire[26];
            this.isWord = false;
        }
    }

    List<String> res = new ArrayList<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Tire root = new Tire();
        // put words into a tire tree
        for (String word: words) {
            if (word.length() > 0) {
                buildTire(root, word);
            }
        }

        // check if is concatenated
        for (String word: words) {
            if (dfs(root, word, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    /**
     * Find the subwords count of a word
     * @param root
     * @param word
     * @param begin
     * @param num
     */
    private boolean dfs(Tire root, String word, int begin, int num) {
        Tire head = root;
        for (int i = begin; i < word.length(); i ++) {
            char cur = word.charAt(i);
            if (head.children[cur - 'a'] == null) {
                return false;
            }
            head = head.children[cur - 'a'];
            if (head.isWord && dfs(root, word, i + 1, num + 1)) {
                return true;
            }
        }
        return (num >= 1 && head.isWord);
    }

    private void buildTire(Tire root, String word) {
        Tire head = root;
        char[] sArr = word.toCharArray();

        for (char c: sArr) {
            if (head.children[c - 'a'] == null) {
                head.children[c - 'a'] = new Tire();
                head = head.children[c - 'a'];
            } else {
                head = head.children[c - 'a'];
            }
        }
        head.isWord = true;
    }
}


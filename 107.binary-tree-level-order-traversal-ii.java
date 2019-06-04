import java.util.ArrayList;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return res;
        }
        levelOrderBottom(root, 0);
        List<List<Integer>> wrap = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i --) {
            wrap.add(res.get(i));
        }
        return wrap;
    }

    private void levelOrderBottom(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        levelOrderBottom(root.left, level + 1);
        levelOrderBottom(root.right, level + 1);
        List<Integer> tmp = res.get(level);
        tmp.add(root.val);
    }
}


import java.util.ArrayList;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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

    List<List<Integer>> res = new ArrayList<>();;

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        levelOrder(root, 0);
        return res;
    }

    private void levelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<Integer>());
        }
        List<Integer> layer = res.get(level);
        layer.add(root.val);
        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);
    }
}


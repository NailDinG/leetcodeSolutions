/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
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
    int leftest = -1;
    int level_leftest = 0;
    public int findBottomLeftValue(TreeNode root) {
        // You may assume the tree (i.e., the given root node) is not NULL.
        // root cannot be null
        leftest = root.val;
        findBottomLeftValue(root, 0);
        return leftest;
    }

    private void findBottomLeftValue(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level_leftest < level) {
            leftest = root.val;
            level_leftest = level;
        }

        findBottomLeftValue(root.left, level + 1);
        findBottomLeftValue(root.right, level + 1);

    }
}


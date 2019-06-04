/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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

    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }    
        minDepth(root, 1);
        return min;
    }

    private void minDepth(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            min = Math.min(level, min);
            return;
        }
        if (level > min) {
            return;
        }
        minDepth(root.left, level + 1);
        minDepth(root.right, level + 1);
        return;
    }
}


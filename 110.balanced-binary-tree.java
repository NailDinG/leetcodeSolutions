import java.util.HashSet;

/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        maxDepth(root, 0);
        return res;
    }

    private int maxDepth(TreeNode root, int depth) {
        
        if (root == null) {
            return depth;
        }

        int l = maxDepth(root.left, depth + 1);
        int r = maxDepth(root.right, depth + 1);

        if (Math.abs(l - r) > 1) {
            res = false;
        }
        return Math.max(l, r);
    }
}


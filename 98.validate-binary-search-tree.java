/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left, Long.MIN_VALUE, root.val) 
            && isValidBST(root.right, root.val, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.left != null && (root.left.val >= max || root.left.val <= min)) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        if (root.right != null && (root.right.val <= min || root.right.val >= max)) {
            return false;
        }
        return isValidBST(root.left, min, root.val) 
            && isValidBST(root.right, root.val, max);
    }
}


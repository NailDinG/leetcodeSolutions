import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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

    List<Integer> res = new ArrayList<>();

    /**
     * Solution I recurse
     * @param root
     * @return
     */
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
    */

    /**
     * Solution II Stack
     * @param root
     * @return
     */
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // do something
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }*/

    /**
     * Solution III Mirrors traversal
     * @param root
     * @return
     */
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                //do something
                res.add(cur.val);
                cur = cur.right;
            } else {
                // 找左子树的最右节点
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right.val != cur.val) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    // do something
                    res.add(cur.val);
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}


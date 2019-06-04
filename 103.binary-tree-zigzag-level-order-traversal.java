import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode c = root;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            while (!stack1.isEmpty()) {
                c = stack1.pop();
                tmp.add(c.val);
                if (c.left != null) {
                    stack2.push(c.left);
                }
                if (c.right != null) {
                    stack2.push(c.right);
                }
            }
            res.add(tmp);
            tmp = new ArrayList<Integer>();
            while (!stack2.isEmpty()) {
                c = stack2.pop();
                tmp.add(c.val);
                if (c.right != null) {
                    stack1.push(c.right);
                }
                if (c.left != null) {
                    stack1.push(c.left);
                }
            }
            if (!tmp.isEmpty()) {
                res.add(tmp);
            }
        }
        return res;
    }
}


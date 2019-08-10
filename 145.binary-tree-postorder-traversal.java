import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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

    List<Integer> res = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        iterative(root);
        return res;
    }

    private void recursive(TreeNode root) {
        if (root == null) {
            return;
        }
        recursive(root.left);
        recursive(root.right);
        res.add(root.val);
    }

    private void iterative(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.add(node);
            if (node.left != null) {
                stack1.add(node.left);
            }
            if (node.right != null) {
                stack1.add(node.right);
            }
        }

        while (stack2.isEmpty() == false) {
            res.add(stack2.pop().val);
        }
    }
}


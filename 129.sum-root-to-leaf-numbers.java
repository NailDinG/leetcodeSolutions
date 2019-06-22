import java.util.*;
/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return res;
    }

    private void sumNumbers(TreeNode root, int cur) {
        if (root == null) {
            res += cur;
            return;
        }
        int tmp = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += tmp;
            return;
        } else if (root.left == null) {
            sumNumbers(root.right, tmp);            
        } else if (root.right == null){
            sumNumbers(root.left, tmp);            
        } else {
            sumNumbers(root.left, tmp);            
            sumNumbers(root.right, tmp);            
        }
    }
}


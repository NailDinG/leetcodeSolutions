/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
    int[] money = new int[]{0, 0};
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] cur = new int[2];
        cur[0] = left[1] + right[1] + root.val;
        cur[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return cur;      
    }
}


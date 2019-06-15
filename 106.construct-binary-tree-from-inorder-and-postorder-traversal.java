import java.util.HashMap;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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

    HashMap<Integer, Integer> inPos = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i ++) {
            inPos.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(postorder[postEnd]);
        int inCur = inPos.get(postorder[postEnd]);
        int numsLeft = inCur - inStart;
        TreeNode left = buildTree(inorder, inStart, inCur - 1, postorder, postStart, postStart + numsLeft - 1);
        TreeNode right = buildTree(inorder, inCur + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1);
        cur.left = left;
        cur.right = right;
        return cur;
    }
}


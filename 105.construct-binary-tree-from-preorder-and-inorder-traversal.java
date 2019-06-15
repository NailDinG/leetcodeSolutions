import java.util.HashMap;
/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i ++) {
            inPos.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, 
        int[] inorder, int inStart, int inEnd) {
        
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int curPos = inPos.get(preorder[preStart]);
        int numsLeft = curPos - inStart;

        treeNode.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, curPos - 1);
        treeNode.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, curPos + 1, inEnd);
        
        return treeNode;
    }
}


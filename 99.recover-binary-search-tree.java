import java.util.LinkedList;

/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode first = null;
        TreeNode second = null;
        TreeNode latest = null;
        TreeNode cur = root;
        LinkedList<TreeNode> mem = new LinkedList<>();

        // mirrors traversal
        while (cur != null) {
            if (cur.left == null) {
                // do something
                
                if (latest != null && latest.val > cur.val) {
                    mem.add(latest);
                    mem.add(cur);
                }
                latest = cur;
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right.val != cur.val) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    // do something
                    if (latest != null && latest.val > cur.val) {
                        mem.add(latest);
                        mem.add(cur);
                    }
                    latest = cur;
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        first = mem.getFirst();
        second = mem.getLast();
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
         
    }
}


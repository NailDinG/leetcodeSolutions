import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return res;
        }
        largestValues(root, 0);
        return res;
    }

    private void largestValues(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (res.size() - 1 < level) {
            res.add(root.val);
        } else if (res.get(level) < root.val) {
            res.set(level, root.val);
        }
        largestValues(root.left, level + 1);
        largestValues(root.right, level + 1);
    }
}


import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        dfs(root, sum, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode cur, int sum, List<Integer> tmpList) {
        if (cur == null) {
            return;
        }
        if (cur.left == null && cur.right == null && sum == cur.val) {
            tmpList.add(cur.val);
            res.add(new ArrayList<>(tmpList));
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        
        tmpList.add(cur.val);
        dfs(cur.left, sum - cur.val, tmpList);
        dfs(cur.right, sum - cur.val, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }
}


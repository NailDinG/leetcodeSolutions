import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {

    List<Integer> mem = new ArrayList<>();
    int curIndex = 0;
    int size = 0;
    public BSTIterator(TreeNode root) {
        iteratorBuilder(root);
        this.size = mem.size();
    }

    private void iteratorBuilder(TreeNode root) {
        if (root == null) {
            return;
        }
        iteratorBuilder(root.left);
        mem.add(root.val);
        iteratorBuilder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        int res = mem.get(curIndex);
        curIndex ++;
        return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curIndex < size;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


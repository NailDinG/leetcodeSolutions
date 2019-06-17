import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    List<Stack<Node>> mem = new ArrayList<>();
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        dfs(root, 0);
        return root;
    }

    private void dfs(Node root, int level) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = null;
        if (mem.size() == level) {
            stack = new Stack<>();
            stack.add(root);
            mem.add(stack);
        } else {
            stack = mem.get(level);
            Node tmp = stack.pop();
            tmp.next = root;
            stack.add(root);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}


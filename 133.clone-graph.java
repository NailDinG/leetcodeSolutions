import java.util.HashMap;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {

    HashMap<Integer, Node> mem = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) {
            return null;
        }

        if (mem.containsKey(node.val)) {
            return mem.get(node.val);
        }

        Node copy = new Node(node.val, new ArrayList<Node>());
        mem.put(node.val, copy);

        for (Node tmp : node.neighbors) {
            copy.neighbors.add(clone(tmp));
        }
        return copy;
    }
}


import java.util.HashMap;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> mem = new HashMap<>();
        Node first = head;
        while (first != null) {
            Node tmp = new Node();
            tmp.val = first.val;
            mem.put(first, tmp);
            first = first.next;
        }

        first = head;
        while (first != null) {
            Node tmp = mem.get(first);
            tmp.next = mem.get(first.next);
            tmp.random = mem.get(first.random);
            first = first.next;
        }
        return mem.get(head);
    }
}


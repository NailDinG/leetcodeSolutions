import java.util.HashMap;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */
class LRUCache {

    class Node {
        int val;
        int pos;
        Node prev;
        Node next;
        Node(int _pos, int _val) {
            this.val = _val;
            this.pos = _pos;
        }
        
        Node() {}
    }

    private int capacity = 0;
    private int size = 0;
    private HashMap<Integer, Node> posMap = new HashMap<>();
    private Node first;
    private Node tail;

    private void addNode(Node node) {
        node.prev = first;
        node.next = first.next;

        first.next.prev = node;
        first.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node end = tail.prev;
        removeNode(end);
        return end;
    }
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        first = new Node();
        first.prev = null;

        tail = new Node();
        tail.next = null;

        first.next = tail;
        tail.prev = first;
    }
    
    public int get(int key) {
        if (posMap.containsKey(key)) {
            moveToHead(posMap.get(key));
            return posMap.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (posMap.containsKey(key)) {
            posMap.get(key).val = value;
            moveToHead(posMap.get(key));
        } else {
            Node node = new Node(key, value);
            posMap.put(key, node);
            addNode(node);
            size ++;
            if (size > capacity) {
                Node end = popTail();
                posMap.remove(end.pos);
                size -- ;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


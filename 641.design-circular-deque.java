/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */
class MyCircularDeque {

    private int rear = -1;
    private int front = -1;
    private int[] deque;
    private int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new int[k]; // k-size deque;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (front == -1 && rear == -1) {
            front = 0; rear = 0;
            deque[0] = value;
            size ++;
        } else {
            if (!isFull()) {
                front = (front - 1 + deque.length) % deque.length;
                deque[front] = value;
                size ++;
            } else {
                return false;
            }
        }
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (front == -1 && rear == -1) {
            front = 0; rear = 0;
            deque[0] = value;
            size ++;
        } else {
            if (!isFull()) {
                rear = (rear + 1) % deque.length;
                deque[rear] = value;
                size ++;
            } else {
                return false;
            }
        }
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            front = (front + 1) % deque.length;
            size --;
        }
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            rear = (rear - 1 + deque.length) % deque.length;
            size --;
        }
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[front];
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return deque[rear];
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == deque.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */


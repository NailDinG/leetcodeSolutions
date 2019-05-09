import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        if (head.next == head) {
            return true;
        }

        ListNode fastPoint = head;
        ListNode slowPoint = head;
        while (fastPoint != null && fastPoint.next != null && fastPoint.next.next != null) {
            fastPoint = fastPoint.next.next;
            slowPoint = slowPoint.next;
            if (fastPoint == slowPoint) {
                return true;
            }
        }
        return false;
    }
}


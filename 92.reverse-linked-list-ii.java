/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode before = sentry;
        for (int i = 0; i < m - 1; i ++) {
            before = before.next;
        }
        ListNode first = before.next;
        ListNode tail = before.next;
        ListNode cur = null;
        
        for (int i = 0; i < n - m; i ++) {
            if (tail.next != null) {
                cur = tail.next;
                tail.next = cur.next;
                cur.next = first;
                before.next = cur;
                first = before.next;
            }
        }
        return sentry.next;
    }
}


/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode before = new ListNode(Integer.MIN_VALUE);
        before.next = head;
        ListNode a = before;
        ListNode b = before;

        while (a != null && a.next != null && a.next.val < x) {
            a = a.next;
        }
        if (a.next == null) {
            return head;
        }

        b = a;

        while (b != null && b.next != null) {
            if (b.next.val < x) {
                ListNode tmp = b;
                ListNode p1 = a.next;
                ListNode p2 = b.next;
                b.next = p2.next;
                p2.next = p1;
                a.next = p2;
                b = tmp;
                a = a.next;
            } else {
                b = b.next;
            }
        }

        return before.next;
    }
}


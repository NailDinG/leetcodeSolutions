/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        int n = 0;
        while (head != null) {
            n ++;
            head = head.next;
        }

        for (int step = 1; step < n; step *= 2) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;

            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
        
    }

    private ListNode split(ListNode node, int step) {
        if (node == null ) {
            return null;
        }
        for (int i = 1; node.next != null && i < step; i ++) {
            node = node.next;
        }

        ListNode res = node.next;
        node.next = null;
        return res;

    }

    private ListNode merge(ListNode node1, ListNode node2, ListNode prev) {
        ListNode cur = prev;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }

        if (node1 != null) cur.next = node1;
        else if (node2 != null) cur.next = node2;
        while (cur.next != null) cur = cur.next;

        return cur;
    }
}


/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = 1;
        ListNode begin = head;
        ListNode end = null;
        while (begin.next != null) {
            len ++;
            begin = begin.next;
        }
        end = begin;
        begin = head;
        end.next = begin;
        int step = len - (k % len) - 1;
        for (int i = 0; i < step; i ++) {
            begin = begin.next;
        }
        head = begin.next;
        begin.next = null;
        return  head;
    }
}


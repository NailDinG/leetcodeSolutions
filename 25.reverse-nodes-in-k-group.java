/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        return mySolution(head, k);
        // ListNode curr = head;
        // int count = 0;
        // while (curr != null && count != k) {
        //     curr = curr.next;
        //     count ++;
        // }

        // if (count == k) {
        //     curr = reverseKGroup(curr, k);
        //     while (count > 0) {
        //         count --;
        //         ListNode tmp = head.next;
        //         head.next = curr;
        //         curr = head;
        //         head = tmp;
        //     }
        //     head = curr;
        // }
        // return head;
    }

    public ListNode mySolution(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n ++;
        }
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        for (ListNode prev = dmy, tail = head; n >= k; n -= k) {
            for (int i = 1; i < k; i ++) {
                ListNode tmp = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = tmp;
            }
            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }
}


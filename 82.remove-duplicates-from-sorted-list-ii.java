/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.val == Integer.MAX_VALUE) {
            return null;
        }
        ListNode sentry = new ListNode(Integer.MAX_VALUE);
        sentry.next = head;
        ListNode lastNode = sentry;
        ListNode endWindow = sentry.next;
        ListNode beginWindow = sentry.next.next;

        while (beginWindow != null) {
            if (endWindow.val == beginWindow.val) {
                while (beginWindow != null && endWindow.val == beginWindow.val) {
                    beginWindow = beginWindow.next;
                }
                lastNode.next = beginWindow;
                if (beginWindow != null) {
                    endWindow = beginWindow;
                    beginWindow = beginWindow.next;
                }
            } else {
                lastNode = endWindow;
                endWindow = endWindow.next;
                beginWindow = beginWindow.next;
            }
        }

        return sentry.next;
        
    }
}


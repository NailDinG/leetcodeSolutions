import java.util.Stack;

/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        Stack<ListNode> stack = new Stack<>();

        while (fast != null) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        fast = head;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = null;
            if (tmp != null) {
                stack.add(tmp);
                //System.out.println(tmp.val);
            }
            slow = tmp;
        }
        while (fast != null) {
            ListNode tmp = fast.next;
            if (!stack.isEmpty()) {
                ListNode tEnd = stack.pop();
                fast.next = tEnd;
                tEnd.next = tmp;
            }
            fast = tmp;
        }
    }
}


package leetcode._1_50._25;

import leetcode.common.ListNode;

/*
25. Reverse Nodes in k-Group
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class LC_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null) {
            prev = reverseK(prev, k);
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode prev, int k) {
        ListNode last = prev;
        for (int i = 0; i < k + 1; i++) {
            last = last.next;
            if (i != k && last == null) {
                return null;
            }
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while (curr != last) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = next;
            curr = next;
        }
        return tail;
    }
}

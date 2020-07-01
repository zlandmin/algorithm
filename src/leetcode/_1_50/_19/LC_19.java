package leetcode._1_50._19;

import leetcode.common.ListNode;

/*
19. Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
 */
public class LC_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();
        slow = dummy;
        fast = dummy;
        while (fast.next != null) {
            if (n <= 0) {
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}

package leetcode._1_100._92;

import leetcode.common.ListNode;

/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */
public class LC_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode mNode = head;
        ListNode preM = dummy;
        ListNode nNode = head;
        for (int i = 0; i < m - 1; i++) {
            mNode = mNode.next;
            preM = preM.next;
        }
        for (int i = 0; i < n - 1; i++) {
            nNode = nNode.next;
        }

        while (mNode != nNode) {
            preM.next = mNode.next;
            mNode.next = nNode.next;
            nNode.next = mNode;
            mNode = preM.next;
        }

        return dummy.next;
    }
}

package leetcode._1_100._2;

import leetcode.common.ListNode;

/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class LC_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        boolean carry = false;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                sum += l2.val;
                l2 = l2.next;
            }
            else if (l2 == null) {
                sum += l1.val;
                l1 = l1.next;
            } else {
                sum += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            if (carry) {
                sum += 1;
            }

            if (sum >= 10) {
                sum %= 10;
                carry = true;
            } else {
                carry = false;
            }

            ListNode newNode = new ListNode(sum);
            cur.next = newNode;
            cur = newNode;
        }
        if (carry) {
            ListNode carryNode = new ListNode(1);
            cur.next = carryNode;
        }

        return dummy.next;
    }
}

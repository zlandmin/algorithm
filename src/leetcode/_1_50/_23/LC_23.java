package leetcode._1_50._23;

import leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class LC_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
           return null;
        }
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }

        while (!queue.isEmpty()) {
            ListNode nd = queue.poll();
            if (nd.next != null) {
                queue.offer(nd.next);
            }
            cur.next = nd;
            cur = nd;
        }
        return head.next;
    }
}

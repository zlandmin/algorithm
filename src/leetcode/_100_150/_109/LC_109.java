package leetcode._100_150._109;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;

/*
109. Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class LC_109 {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        } else {
            ListNode mid = start;
            ListNode fast = start;
            while (fast != null && fast.next != null) {
                mid = mid.next;
                fast = fast.next.next;
            }
            TreeNode cur = new TreeNode(mid.val);
            cur.left = helper(start, mid);
            cur.right = helper(mid.next, end);
            return cur;
        }
    }
}

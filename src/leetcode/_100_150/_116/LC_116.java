package leetcode._100_150._116;

import leetcode.common.BNode;

/*
116. Populating Next Right Pointers in Each Node
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.


Example 1:



Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class LC_116 {
    public BNode connect(BNode root) {
        if (root == null) {
            return null;
        }
        BNode fisrtAtLevel = root;
        while (fisrtAtLevel != null) {
            BNode curAtLevel = fisrtAtLevel;
            while (curAtLevel != null) {
                if (curAtLevel.left != null) {
                    curAtLevel.left.next = curAtLevel.right;
                }
                if (curAtLevel.right != null && curAtLevel.next != null) {
                    curAtLevel.right.next = curAtLevel.next.left;
                }
                curAtLevel = curAtLevel.next;
            }
            fisrtAtLevel = fisrtAtLevel.left;
        }
        return root;
    }

//    public Node connect(Node root) {
//        if (root == null) {
//            return null;
//        }
//        helper(root);
//        return root;
//    }
//
//    private void helper(Node root) {
//        if (root == null) {
//            return;
//        }
//        if (root.left != null) {
//            root.left.next = root.right;
//            helper(root.left);
//        }
//        if (root.right != null) {
//            if (root.next != null) {
//                root.right.next = root.next.left;
//            }
//            helper(root.right);
//        }
//    }
}

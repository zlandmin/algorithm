package leetcode._100_150._117;

import leetcode.common.BNode;

/*
117. Populating Next Right Pointers in Each Node II
Given a binary tree

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



Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class LC_117 {
    public BNode connect(BNode root) {
        if (root == null) {
            return root;
        }
        BNode firstBNodeLevel = root;
        while (firstBNodeLevel != null) {
            BNode curLevel = firstBNodeLevel;
            while (curLevel != null) {
                if (curLevel.left != null) {
                    if (curLevel.right != null) {
                        curLevel.left.next = curLevel.right;
                    } else {
                        curLevel.left.next = findCloestNode(curLevel);
                    }
                }
                if (curLevel.right != null) {
                    curLevel.right.next = findCloestNode(curLevel);
                }
                curLevel = curLevel.next;
            }
            firstBNodeLevel = findNextFirstNode(firstBNodeLevel);
        }
        return root;
    }

    private BNode findNextFirstNode(BNode BNode) {
        while (BNode != null) {
            if (BNode.left != null) {
                return BNode.left;
            }
            if (BNode.right != null) {
                return BNode.right;
            }
            BNode = BNode.next;
        }
        return BNode;
    }

    private BNode findCloestNode(BNode BNode) {
        if (BNode == null) {
            return null;
        }
        BNode = BNode.next;
        while (BNode != null) {
            if (BNode.left != null) {
                return BNode.left;
            }
            if (BNode.right != null) {
                return BNode.right;
            }
            BNode = BNode.next;
        }
        return null;
    }
}

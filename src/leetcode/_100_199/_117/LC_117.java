package leetcode._100_199._117;

import com.sun.jmx.snmp.SnmpNull;
import leetcode.common.Node;

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
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node firstNodeLevel = root;
        while (firstNodeLevel != null) {
            Node curLevel = firstNodeLevel;
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
            firstNodeLevel = findNextFirstNode(firstNodeLevel);
        }
        return root;
    }

    private Node findNextFirstNode(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return node;
    }

    private Node findCloestNode(Node node) {
        if (node == null) {
            return null;
        }
        node = node.next;
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }
}

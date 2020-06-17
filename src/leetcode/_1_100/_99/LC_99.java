package leetcode._1_100._99;

import leetcode.common.TreeNode;

/*
99. Recover Binary Search Tree
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
 */
public class LC_99 {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = new TreeNode();
        cur = root;
        TreeNode fisrt = new TreeNode();
        TreeNode second = new TreeNode();
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        boolean firstOcur = true;
        while (cur != null) {
            if (cur.left == null) {
                if (pre.val > cur.val && firstOcur) {
                    fisrt = pre;
                    firstOcur = false;
                }
                if (pre.val > cur.val && !firstOcur) {
                    second = cur;
                }
                pre = cur;
                cur = cur.right;
            } else {
                TreeNode tmp = new TreeNode();
                tmp = cur.left;
                while (tmp.right != null && tmp.right != cur) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = cur;
                    cur = cur.left;
                } else {
                    if (pre.val > cur.val && firstOcur) {
                        fisrt = pre;
                        firstOcur = false;
                    }
                    if (pre.val > cur.val && !firstOcur) {
                        second = cur;
                    }
                    pre = cur;
                    tmp.right = null;
                    cur = cur.right;
                }
            }
        }
        if (fisrt != null && second != null) {
            int temp = fisrt.val;
            fisrt.val = second.val;
            second.val = temp;
        }
    }
}

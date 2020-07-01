package leetcode._100_150._114;

import leetcode.common.TreeNode;

/*
114. Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class LC_114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode rightNode = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode leftLast = root;
            while (leftLast.right != null) {
                leftLast = leftLast.right;
            }
            leftLast.right = rightNode;
        }
    }
}

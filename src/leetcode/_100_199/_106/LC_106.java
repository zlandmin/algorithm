package leetcode._100_199._106;

import leetcode.common.TreeNode;

/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class LC_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0
                || inorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }
        return helper(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int post_str, int in_str, int in_end) {
        if (post_str < 0 || in_str > in_end) {
            return null;
        }
        TreeNode cur = new TreeNode(postorder[post_str]);
        int idx = in_str;
        while (idx <= in_end) {
            if (inorder[idx] == postorder[post_str]) {
                break;
            }
            idx++;
        }
        cur.left = helper(postorder, inorder, post_str - (in_end - idx + 1), in_str, idx - 1);
        cur.right = helper(postorder, inorder, post_str - 1, idx + 1, in_end);
        return cur;
    }
}

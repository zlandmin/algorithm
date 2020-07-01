package leetcode._100_150._105;

import leetcode.common.TreeNode;

/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class LC_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0
                || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pre_str, int in_str, int in_end) {
        if (pre_str > preorder.length || in_str > in_end) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[pre_str]);
        int idx = in_str;
        while (idx <= in_end) {
            if (inorder[idx] == preorder[pre_str]) {
                break;
            }
            idx++;
        }
        cur.left = buildTree(preorder, inorder, pre_str + 1, in_str, idx - 1);
        cur.right = buildTree(preorder, inorder, pre_str + (idx - in_str + 1), idx + 1, in_end);

        return cur;
    }
}

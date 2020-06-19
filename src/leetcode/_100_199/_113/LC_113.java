package leetcode._100_199._113;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
113. Path Sum II
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class LC_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, new ArrayList<>(), sum, root);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, int target, TreeNode node) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (target == node.val) {
                res.add(new ArrayList<>(path));
            }
        }
        if (node.left != null) {
            helper(res, path, target - node.val, node.left);
        }
        if (node.right != null) {
            helper(res, path, target - node.val, node.right);
        }
        path.remove(path.size() - 1);
    }
}

package leetcode._151_199._199;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
199. Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class LC_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(root.val);
        }
        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);
    }
}

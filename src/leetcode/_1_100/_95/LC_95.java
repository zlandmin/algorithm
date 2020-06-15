package leetcode._1_100._95;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
95. Unique Binary Search Trees II
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class LC_95 {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int min, int max) {
        List<TreeNode> res = new ArrayList<>();
        if (min > max) {
            return res;
        }
        for (int rv = min; rv <= max; rv++) {
            List<TreeNode> leftList = helper(min, rv - 1);
            List<TreeNode> rightList = helper(rv + 1, max);
            if (leftList.size() == 0 && rightList.size() == 0) {
                TreeNode root = new TreeNode(rv);
                res.add(root);
            } else if (leftList.size() == 0) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(rv);
                    root.right = right;
                    res.add(root);
                }
            } else if (rightList.size() == 0) {
                for (TreeNode left : leftList) {
                    TreeNode root = new TreeNode(rv);
                    root.left = left;
                    res.add(root);
                }
            } else {
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode root = new TreeNode(rv);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}

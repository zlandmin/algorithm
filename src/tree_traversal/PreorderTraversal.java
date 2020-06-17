package tree_traversal;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorder_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preorder_helper(root, res);
        return res;
    }

    private void preorder_helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder_helper(root.left, res);
        preorder_helper(root.right, res);
    }

    public List<Integer> preorder_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root.left;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }

    public List<Integer> preorder_morris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = new TreeNode();
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    prev = prev.right;
                }
            }
        }
        return res;
    }
}

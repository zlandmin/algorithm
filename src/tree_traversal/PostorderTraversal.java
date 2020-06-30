package tree_traversal;

import leetcode.common.TreeNode;

import java.util.*;

public class PostorderTraversal {
    public List<Integer> postorder_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postorder_helper(root, res);
        return res;
    }

    private void postorder_helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        postorder_helper(root.left, res);
        postorder_helper(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorder_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                res.add(cur.val);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postorder_morris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                res.add(cur.val);
                cur = cur.left;
            } else {
                TreeNode prev = new TreeNode();
                prev = cur.right;
                while (prev.left != null && prev.left != cur) {
                    prev = prev.left;
                }
                if (prev.left == null) {
                    prev.left = cur;
                    res.add(cur.val);
                    cur = cur.right;
                } else {
                    prev.left = null;
                    prev = prev.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
}

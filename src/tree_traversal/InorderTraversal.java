package tree_traversal;

import com.sun.jmx.snmp.SnmpNull;
import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public List<Integer> inorder_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inorder_helper(root, res);
        return res;
    }

    private void inorder_helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder_helper(root.left, res);
        res.add(root.val);
        inorder_helper(root.right, res);
    }

    public List<Integer> inorder_iterative(TreeNode root) {
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
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public List<Integer> inorder_morris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = new TreeNode();
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
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
                    res.add(cur.val);
                    tmp.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}

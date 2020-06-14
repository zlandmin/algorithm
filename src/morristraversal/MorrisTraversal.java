package morristraversal;

import leetcode.common.TreeNode;

public class MorrisTraversal {
    public void inorder(TreeNode root) {
        TreeNode cur = new TreeNode();
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val);
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
                    System.out.println(cur.val);
                    tmp.right = null;
                    cur = cur.right;
                }
            }
        }
    }
}

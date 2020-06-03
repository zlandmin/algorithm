package morristraversal;

import leetcode.common.TNode;

public class MorrisTraversal {
    public void inorder(TNode root) {
        TNode cur = new TNode();
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                TNode tmp = new TNode();
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

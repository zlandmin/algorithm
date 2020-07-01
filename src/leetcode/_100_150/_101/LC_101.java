package leetcode._100_150._101;

import leetcode.common.TreeNode;

/*
101. Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


Follow up: Solve it both recursively and iteratively.
 */
public class LC_101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        q.add(root);
//        while (!q.isEmpty()) {
//            TreeNode t1 = q.poll();
//            TreeNode t2 = q.poll();
//            if (t1 == null && t2 == null) continue;
//            if (t1 == null || t2 == null) return false;
//            if (t1.val != t2.val) return false;
//            q.add(t1.left);
//            q.add(t2.right);
//            q.add(t1.right);
//            q.add(t2.left);
//        }
//        return true;
//    }
}

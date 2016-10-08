package leetcode.trees;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _101Symmetric {
    static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return findSym(root.left, root.right);
    }

    static boolean findSym(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;
        if (!findSym(p.left, q.right))
            return false;
        return findSym(p.right, q.left);

    }
}

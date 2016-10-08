package leetcode.general;

/**
 * Created by nagabharan on 27-Sep-16.
 */
public class _101SymmetricTree {
    static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    static boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;
        if (l.val != r.val)
            return false;
        if (!isSymmetric(l.left, r.right))
            return false;
        return isSymmetric(l.right, r.left);
    }

    public static void main(String[] args) {

    }
}

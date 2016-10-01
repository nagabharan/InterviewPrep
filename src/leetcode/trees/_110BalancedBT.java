package leetcode.trees;

/**
 * Created by nagabharan on 01-Oct-16.
 */
public class _110BalancedBT {
    static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return getH(root) != -1;
    }

    static int getH(TreeNode root) {
        if (root == null)
            return 0;

        int l = getH(root.left);
        int r = getH(root.right);

        if (l == -1 || r == -1)
            return -1;

        if (Math.abs(l - r) > 1)
            return -1;

        return Math.max(l, r) + 1;
    }
}
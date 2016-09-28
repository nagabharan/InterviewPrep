package leetcode;

/**
 * Created by nagabharan on 27-Sep-16.
 */
public class _110BalancedBinaryTree {
    static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return getH(root) != -1;
    }

    static int getH(TreeNode root) {
        if (root == null)
            return 0;

        int left = getH(root.left);
        int right = getH(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}

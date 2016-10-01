package leetcode.trees;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _98ValidBST {
    static boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

    }

    static boolean isValid(TreeNode p, double min, double max) {
        if (p == null)
            return true;

        if (p.value <= min || p.value >= max)
            return false;

        return isValid(p.left, min, p.value) && isValid(p.right, p.value, max);
    }
}

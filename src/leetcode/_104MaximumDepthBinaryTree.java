package leetcode;

/**
 * Created by nagabharan on 27-Sep-16.
 */
public class _104MaximumDepthBinaryTree {
    static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int max = Math.max(left, right);
        return max + 1;
    }
}

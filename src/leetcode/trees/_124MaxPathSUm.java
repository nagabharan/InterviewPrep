package leetcode.trees;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _124MaxPathSUm {
    static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxSum(root, max);
        return max[0];
    }

    static int maxSum(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        int l = maxSum(root.left, max);
        int r = maxSum(root.right, max);

        int cur = Math.max(root.val, Math.max(l + root.val, r + root.val));
        max[0] = Math.max(max[0], Math.max(cur, l + r + root.val));
        return cur;
    }
}

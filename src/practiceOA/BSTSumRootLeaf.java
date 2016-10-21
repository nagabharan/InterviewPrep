package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class BSTSumRootLeaf {
    public int minSum(TN root) {
        if (root == null) return 0;
        if (root.left != null && root.right == null)
            return minSum(root.left) + root.val;
        if (root.left == null && root.right != null)
            return minSum(root.right) + root.val;
        return Math.min(minSum(root.left), minSum(root.right)) + root.val;
    }
}

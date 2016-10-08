package leetcode.trees;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _108SortedArraytoBST {
    static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null)
            return null;

        return buildTree(nums, 0, nums.length - 1);
    }

    static TreeNode buildTree(int[] nums, int b, int e) {
        if (b > e)
            return null;

        int mid = (b + e) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = (buildTree(nums, b, mid - 1));
        root.right = (buildTree(nums, mid + 1, e));

        return root;
    }
}

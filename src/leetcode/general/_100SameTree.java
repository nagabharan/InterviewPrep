package leetcode.general;

/**
 * Created by nagabharan on 27-Sep-16.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class _100SameTree {
    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;
        else
            return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}

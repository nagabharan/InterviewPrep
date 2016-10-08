package leetcode.trees;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _235LCABST {
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode m = root;

        if (m.val >= p.val && m.val <= q.val)
            return m;

        else if (m.val > p.val && m.val > q.val)
            return lowestCommonAncestor(m.left, p, q);
        else if (m.val < p.val && m.val < q.val)
            return lowestCommonAncestor(m.right, p, q);

        return root;
    }
}

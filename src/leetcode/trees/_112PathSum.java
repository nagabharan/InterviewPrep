package leetcode.trees;

import java.util.LinkedList;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _112PathSum {
    static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> val = new LinkedList<>();

        q.add(root);
        val.add(root.val);

        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            int s = val.remove();

            if (n.left == null && n.right == null && s == sum) {
                return true;
            }
            if (n.left != null) {
                q.add(n.left);
                val.add(s + n.left.val);
            }
            if (n.right != null) {
                q.add(n.right);
                val.add(s + n.right.val);
            }
        }
        return false;
    }
}

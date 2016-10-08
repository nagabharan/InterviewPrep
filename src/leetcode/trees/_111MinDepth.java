package leetcode.trees;

import java.util.LinkedList;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _111MinDepth {
    static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> val = new LinkedList<>();

        q.add(root);
        val.add(1);

        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            int l = val.remove();

            if (n.left == null && n.right == null)
                return l;

            if (n.left != null) {
                q.add(n.left);
                val.add(l + 1);
            }

            if (n.right != null) {
                q.add(n.right);
                val.add(l + 1);
            }
        }
        return 0;
    }
}

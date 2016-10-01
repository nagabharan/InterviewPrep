package leetcode.trees;

import java.util.LinkedList;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _226InvertBT {
    static TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.remove();

            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);

            TreeNode tmp = n.left;
            n.left = n.right;
            n.right = tmp;
        }

        return root;
    }
}

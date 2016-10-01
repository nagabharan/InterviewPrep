package leetcode.trees;

import java.util.LinkedList;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _298LongestConsecutiveSequence {

    static int longestConsecutiveSequence(TreeNode root) {

        if (root == null)
            return 0;

        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> lev = new LinkedList<>();

        q.add(root);
        lev.add(1);
        int max = 1;

        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            int l = lev.remove();

            if (n.left != null) {
                int LS = l;
                if (n.val == n.left.val - 1) {
                    LS++;
                    max = Math.max(max, LS);
                } else {
                    LS = 1;
                }
                q.add(n.left);
                lev.add(LS);
            }

            if (n.right != null) {
                int LS = l;
                if (n.val == n.right.val - 1) {
                    LS++;
                    max = Math.max(max, LS);
                } else {
                    LS = 1;
                }
                q.add(n.right);
                lev.add(LS);
            }
        }
        return max;
    }
}

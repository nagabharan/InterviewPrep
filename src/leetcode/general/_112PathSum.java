package leetcode.general;

import java.util.LinkedList;

/**
 * Created by nagabharan on 27-Sep-16.
 */
public class _112PathSum {
    static boolean hasPathSum(TreeNode root, int sum) {
        /*if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val==sum)
            return true;
        return (hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));*/
        if (root == null)
            return false;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> values = new LinkedList<>();

        nodes.add(root);
        values.add(root.val);

        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.remove();
            int sumval = values.remove();

            if (cur.left == null && cur.right == null && sumval == sum)
                return true;

            if (cur.left != null) {
                nodes.add(cur.left);
                values.add(cur.left.val + sumval);
            }

            if (cur.right != null) {
                nodes.add(cur.right);
                values.add(cur.right.val + sumval);
            }
        }
        return false;
    }
}

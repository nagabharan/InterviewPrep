package leetcode.trees;

import java.util.Stack;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _230KthSmallestElem {
    static int kthSmallest(TreeNode root, int k) {

        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        int res = 0;

        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            res++;

            if (res == k) {
                return n.val;
            }
            TreeNode r = n.right;
            while (r != null) {
                stack.push(r);
                r = r.left;
            }
        }
        return res;
    }
}

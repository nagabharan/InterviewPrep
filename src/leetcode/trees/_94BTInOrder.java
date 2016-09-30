package leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _94BTInOrder {
    static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode n = stack.peek();
            if (n.left != null) {
                stack.push(n.left);
                n.left = null;
            } else {
                TreeNode tmp = stack.pop();
                res.add(tmp.value);
                if (n.right != null) {
                    stack.push(n.right);
                }
            }
        }

        return res;
    }
}

package leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _145BTPostOrder {
    List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode n = stack.peek();
            if (n.left == null && n.right == null) {
                TreeNode temp = stack.pop();
                res.add(temp.value);
            } else {
                if (n.right != null) {
                    stack.push(n.right);
                    n.right = null;
                }
                if (n.left != null) {
                    stack.push(n.left);
                    n.left = null;
                }
            }
        }

        return res;

    }

}

package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _102BTLevelOrder {
    static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        ArrayList<Integer> l = new ArrayList<>();
        LinkedList<TreeNode> curr = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        curr.add(root);

        while (!curr.isEmpty()) {
            TreeNode n = curr.remove();
            if (n.left != null) {
                next.add(n.left);
            }
            if (n.right != null) {
                next.add(n.right);
            }
            l.add(n.value);
            if (curr.isEmpty()) {
                curr = next;
                next = new LinkedList<>();
                res.add(l);
                l = new ArrayList<>();
            }
        }

        return res;
    }
}

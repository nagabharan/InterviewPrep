package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _107BTReverseLevelOrder {
    static List<List<Integer>> levelOrderBottom(TreeNode root) {

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
            l.add(n.val);
            if (curr.isEmpty()) {
                curr = next;
                next = new LinkedList<>();
                res.add(l);
                l = new ArrayList<>();
            }
        }

        List<List<Integer>> rev = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            rev.add(res.get(i));
        }

        return rev;
    }
}

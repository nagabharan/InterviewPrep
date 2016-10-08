package leetcode.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nagabharan on 27-Sep-16.
 */
public class _102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> nodev = new ArrayList<>();

        if (root == null)
            return list;

        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        cur.add(root);

        while (!cur.isEmpty()) {
            TreeNode tmp = cur.remove();

            if (tmp.left != null)
                next.add(tmp.left);
            if (tmp.right != null)
                next.add(tmp.right);

            nodev.add(tmp.val);

            if (cur.isEmpty()) {
                cur = next;
                next = new LinkedList<>();
                list.add(nodev);
                nodev = new ArrayList<>();
            }
        }

        return list;

    }
}

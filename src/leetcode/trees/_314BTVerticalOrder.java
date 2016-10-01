package leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _314BTVerticalOrder {

    TreeNode root;

    static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();

        queue.add(root);
        level.add(0);

        int minlevel = 0, maxlevel = 0;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            int l = level.remove();

            minlevel = Math.min(minlevel, l);
            maxlevel = Math.max(maxlevel, l);

            if (map.containsKey(l)) {
                map.get(l).add(temp.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.val);
                map.put(l, list);
            }

            if (temp.left != null) {
                queue.add(temp.left);
                level.add(l - 1);
            }
            if (temp.right != null) {
                queue.add(temp.right);
                level.add(l + 1);
            }
        }

        for (int i = minlevel; i <= maxlevel; i++) {
            if (map.containsKey(i))
                res.add(map.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        _314BTVerticalOrder tree = new _314BTVerticalOrder();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(5);
        System.out.println(verticalOrder(tree.root));
    }
}

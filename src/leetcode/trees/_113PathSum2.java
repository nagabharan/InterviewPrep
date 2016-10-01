package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _113PathSum2 {
    static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        ArrayList<Integer> l = new ArrayList<>();
        l.add(root.val);
        dfs(root, sum - root.val, res, l);
        return res;
    }

    static void dfs(TreeNode p, int sum, List<List<Integer>> res, ArrayList<Integer> list) {
        if (p.left == null && p.right == null && sum == 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            res.add(temp);
        }
        if (p.left != null) {
            list.add(p.left.val);
            dfs(p.left, sum - p.left.val, res, list);
            list.remove(list.size() - 1);
        }
        if (p.right != null) {
            list.add(p.right.val);
            dfs(p.right, sum - p.right.val, res, list);
            list.remove(list.size() - 1);
        }
    }
}

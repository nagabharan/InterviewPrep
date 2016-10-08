package leetcode.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 27-Sep-16.
 */
public class _113PathSumII {
    static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        DFSutil(root, sum - root.val, res, list);
        return res;
    }

    static void DFSutil(TreeNode t, int sum, List<List<Integer>> res, ArrayList<Integer> list) {
        if (t.left == null && t.right == null && sum == 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(list);
            res.add(tmp);
        }

        if (t.left != null) {
            list.add(t.left.val);
            DFSutil(t.left, sum - t.left.val, res, list);
            list.remove(list.size() - 1);
        }

        if (t.right != null) {
            list.add(t.right.val);
            DFSutil(t.right, sum - t.right.val, res, list);
            list.remove(list.size() - 1);
        }
    }
}

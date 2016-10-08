package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _95UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        return helper(1, n);
    }

    public List<TreeNode> helper(int m, int n) {
        List<TreeNode> res = new ArrayList<>();
        if (m > n) {
            res.add(null);
            return res;
        }

        for (int i = m; i <= n; i++) {
            List<TreeNode> ls = helper(m, i - 1);
            List<TreeNode> rs = helper(i + 1, n);
            for (TreeNode l : ls)
                for (TreeNode r : rs) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    res.add(cur);
                }
        }

        return res;
    }
}

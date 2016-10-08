package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _199BTRightSideView {
    static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode n = q.remove();
                if (i == 0)
                    res.add(n.val);
                if (n.right != null)
                    q.add(n.right);
                if (n.left != null)
                    q.add(n.left);
            }
        }
        return res;
    }
}

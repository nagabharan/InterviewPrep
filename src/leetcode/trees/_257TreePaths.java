package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _257TreePaths {
    static List<String> binaryTreePaths(TreeNode root) {
        List<String> f = new ArrayList<>();
        if (root == null)
            return f;

        ArrayList<String> cur = new ArrayList<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        dfs(root, res, cur);

        for (ArrayList<String> al : res) {
            StringBuilder sb = new StringBuilder();
            sb.append(al.get(0));
            for (int i = 1; i < al.size(); i++)
                sb.append("->" + al.get(i));
            f.add(sb.toString());
        }
        return f;
    }

    static void dfs(TreeNode root, ArrayList<ArrayList<String>> list, ArrayList<String> curr) {
        curr.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            list.add(curr);
            return;
        }
        if (root.left != null) {
            ArrayList<String> l = new ArrayList<>(curr);
            dfs(root.left, list, l);
        }
        if (root.right != null) {
            ArrayList<String> l = new ArrayList<>(curr);
            dfs(root.right, list, l);
        }
    }
}

package leetcode.trees;

import java.util.LinkedList;

/**
 * Created by nagabharan on 01-Oct-16.
 */
public class _297SerialDeSerialBT {
    static String serialize(TreeNode root) {
        if (root == null)
            return "";

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            if (n != null) {
                sb.append(String.valueOf(n.val) + ",");
                q.add(n.left);
                q.add(n.right);
            } else {
                sb.append("#,");
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));

        int i = 1;
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.remove();

            if (n == null)
                continue;

            if (!arr[i].equals("#")) {
                n.left = new TreeNode(Integer.valueOf(arr[i]));
                q.add(n.left);
            } else {
                n.left = null;
                q.add(n.left);
            }
            i++;

            if (!arr[i].equals("#")) {
                n.right = new TreeNode(Integer.valueOf(arr[i]));
                q.add(n.right);
            } else {
                n.right = null;
                q.add(n.right);
            }
            i++;

        }
        return root;
    }
}

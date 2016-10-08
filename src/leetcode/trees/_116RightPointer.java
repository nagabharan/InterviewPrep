package leetcode.trees;

import java.util.LinkedList;

/**
 * Created by nagabharan on 07-Oct-16.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class _116RightPointer {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        LinkedList<TreeLinkNode> q = new LinkedList<>();
        LinkedList<Integer> dep = new LinkedList<>();

        q.add(root);
        dep.add(1);

        while (!q.isEmpty()) {
            TreeLinkNode t = q.remove();
            int d = dep.remove();

            if (dep.isEmpty()) {
                t.next = null;
            } else if (dep.peek() > d) {
                t.next = null;
            } else {
                t.next = q.peek();
            }

            if (t.left != null) {
                q.add(t.left);
                dep.add(d + 1);
            }
            if (t.right != null) {
                q.add(t.right);
                dep.add(d + 1);
            }
        }
    }
}

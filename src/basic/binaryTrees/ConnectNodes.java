package basic.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nagabharan on 17-Sep-16.
 */

class linkNode {
    int key;
    linkNode left, right;
    linkNode next;

    linkNode(int v) {
        key = v;
        left = right = next = null;
    }
}

public class ConnectNodes {
    linkNode root;

    public static void main(String[] args) {
        ConnectNodes tree = new ConnectNodes();
        tree.root = new linkNode(1);
        tree.root.left = new linkNode(2);
        tree.root.right = new linkNode(3);
        tree.root.left.left = new linkNode(4);
        tree.root.left.right = new linkNode(5);

    }

    void levelOrder(linkNode n) {
        if (n == null)
            return;

        Queue<linkNode> q = new LinkedList<>();
        q.add(n);
        q.add(null);

        while (!q.isEmpty()) {
            linkNode tmp = q.poll();
            if (tmp != null) {
                tmp.next = q.peek();
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            } else {
                if (q.peek() != null)
                    q.add(null);
            }
        }
    }

    void levelOrderConst(linkNode n) {
        if (n == null)
            return;
        if (n.left == null && n.right == null)
            return;
        if (n.left != null) {
            if (n.right != null)
                n.left.next = n.right;
            else {
                if (n.next == null)
                    n.left.next = n.next;
                else {
                    linkNode tmp = n;
                    while (tmp != null && tmp.next.left == null && tmp.next.right == null)
                        tmp = tmp.next;
                    if (tmp == null)
                        n.left.next = null;
                    else if (tmp.next.left != null)
                        n.left.next = tmp.next.left;
                    else
                        n.left.next = tmp.next.right;
                }

            }
        }
        if (n.right != null) {
            if (n.right != null)
                n.right.next = null;
            else {
                linkNode tmp = n;
                while (tmp != null && tmp.left == null && tmp.right == null)
                    tmp = tmp.next;
                if (tmp == null)
                    n.right.next = null;
                else if (tmp.left != null)
                    n.right.next = tmp.left;
                else
                    n.right.next = tmp.right;
            }
        }
        levelOrderConst(n.left);
        levelOrderConst(n.right);
    }
}

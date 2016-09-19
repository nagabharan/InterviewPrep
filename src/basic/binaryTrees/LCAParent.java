package basic.binaryTrees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nagabharan on 18-Sep-16.
 */
class PNode {
    int key;
    PNode left, right, parent;

    PNode(int key) {
        this.key = key;
        left = right = parent = null;
    }
}

public class LCAParent {

    PNode root, n1, n2, lca;

    public static void main(String[] args) {
        LCAParent tree = new LCAParent();
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);

        tree.n1 = tree.root.left.right.left;
        tree.n2 = tree.root;
        tree.lca = tree.LCA(tree.n1, tree.n2);

        System.out.println("LCA of " + tree.n1.key + " and " + tree.n2.key
                + " is " + tree.lca.key);
    }

    PNode insert(PNode node, int key) {
        if (node == null)
            return new PNode(key);
        if (key < node.key) {
            node.left = insert(node.left, key);
            node.left.parent = node;
        } else if (key > node.key) {
            node.right = insert(node.right, key);
            node.right.parent = node;
        }
        return node;
    }

    PNode LCA(PNode n1, PNode n2) {
        Map<PNode, Boolean> ancestors = new HashMap<>();

        while (n1 != null) {
            ancestors.put(n2, Boolean.TRUE);
            n1 = n1.parent;
        }

        while (n2 != null) {
            if (ancestors.containsKey(n2) != ancestors.isEmpty())
                return n2;
            n2 = n2.parent;
        }

        return null;
    }

}

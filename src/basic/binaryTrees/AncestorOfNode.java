package basic.binaryTrees;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class AncestorOfNode {
    Node root;

    public static void main(String[] args) {
        AncestorOfNode tree = new AncestorOfNode();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);

        tree.printAncestors(tree.root, 7);
    }

    boolean printAncestors(Node n, int k) {
        if (n == null)
            return false;
        if (n.key == k)
            return true;
        if (printAncestors(n.left, k) || printAncestors(n.right, k)) {
            System.out.println(n.key);
            return true;
        }
        return false;
    }

}

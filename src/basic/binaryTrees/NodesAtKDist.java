package basic.binaryTrees;

/**
 * Created by nagabharan on 17-Sep-16.
 */

public class NodesAtKDist {

    Node root;

    static int height(Node n) {
        if (n == null)
            return 0;
        return (1 + Math.max(height(n.left), height(n.right)));
    }

    public static void main(String[] args) {

        NodesAtKDist tree = new NodesAtKDist();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        for (int i = 0; i < height(tree.root); i++) {
            System.out.println("at height " + i);
            tree.printKDist(tree.root, i);
        }
    }

    void printKDist(Node n, int k) {
        if (n == null)
            return;
        if (k == 0) {
            System.out.println(n.key);
            return;
        } else {
            printKDist(n.left, k - 1);
            printKDist(n.right, k - 1);
        }
    }
}

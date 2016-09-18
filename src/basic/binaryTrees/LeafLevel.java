package basic.binaryTrees;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class LeafLevel {
    static int level = 0;
    Node root;

    public static void main(String[] args) {
        LeafLevel tree = new LeafLevel();
        tree.root = new Node(12);
        tree.root.left = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(9);
        tree.root.left.left.left = new Node(1);
        //tree.root.right= new Node(12);
        tree.root.left.right.left = new Node(1);
        if (tree.checkUtil(tree.root, 0))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }

    boolean checkUtil(Node n, int l) {
        if (n == null)
            return true;

        if (n.left == null & n.right == null) {
            if (level == 0) {
                level = l;
                return true;
            }
            return l == level;
        }
        return checkUtil(n.left, l + 1) && checkUtil(n.right, l + 1);
    }
}

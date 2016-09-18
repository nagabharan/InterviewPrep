package basic.binaryTrees;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class SubtreeOfAnother {
    Node root1, root2;

    public static void main(String[] args) {
        SubtreeOfAnother tree = new SubtreeOfAnother();

        tree.root1 = new Node(10);
        tree.root1.left = new Node(5);
        tree.root1.right = new Node(6);
        tree.root1.left.left = new Node(3);
        tree.root1.left.right = new Node(2);

        tree.root2 = new Node(5);
        tree.root2.left = new Node(3);
        tree.root2.right = new Node(2);

        System.out.println(tree.isSubtree(tree.root1, tree.root2));
    }

    boolean isSame(Node r1, Node r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null)
            return false;
        return (r1.key == r2.key) && isSame(r1.left, r2.left) && isSame(r1.right, r2.right);
    }

    boolean isSubtree(Node t, Node s) {
        if (s == null)
            return true;
        if (t == null)
            return false;
        if (isSame(t, s))
            return true;
        return isSubtree(t.left, s) || isSubtree(t.right, s);
    }
}

package basic.binaryTrees;

/**
 * Created by nagabharan on 18-Sep-16.
 * <p>
 * Find max sum across:
 * 1. ListNode only
 * 2. Max path through Left Child + ListNode
 * 3. Max path through Right Child + ListNode
 * 4. Max path through Left Child + ListNode + Max path through Right Child
 */
class Res {
    public int sum;
}

public class MaxSum {
    Node root;

    static int pathSum(Node n, Res res) {
        if (n == null)
            return 0;

        int l = pathSum(n.left, res);
        int r = pathSum(n.right, res);

        int max_single = Math.max(Math.max(l, r) + n.key, n.key);
        int max_top = Math.max(max_single, l + r + n.key);

        res.sum = Math.max(res.sum, max_top);
        return max_single;
    }

    static int findSum(Node n) {
        Res r = new Res();
        r.sum = Integer.MIN_VALUE;

        pathSum(n, r);
        return r.sum;
    }

    public static void main(String[] args) {
        MaxSum tree = new MaxSum();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);
        System.out.println("maximum path sum is : " +
                findSum(tree.root));
    }
}

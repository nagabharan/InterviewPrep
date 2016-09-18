package basic.binaryTrees;

/**
 * Created by nagabharan on 17-Sep-16.
 */

import java.util.Stack;

class Node {
    int key;
    Node left, right;

    Node(int v) {
        key = v;
        left = right = null;
    }
}

public class BinaryTree {

    static int preIndex = 0;
    Node root;

    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("diameter");
        System.out.println(diameter(tree.root));
        System.out.println("min");
        System.out.println(findMin(tree.root));
        System.out.println("max");
        System.out.println(findMax(tree.root));
        System.out.println("size");
        System.out.println(size(tree.root));
        System.out.println("inorder");
        inorder(tree.root);
        System.out.println("preorder");
        preorder(tree.root);
        System.out.println("postorder");
        postorder(tree.root);
        System.out.println("levelorder");
        levelorder(tree.root);
        System.out.println("inorderStack");
        inorderStack(tree.root);

        System.out.println("buildtree");
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        Node root = tree.buildTree(in, pre, 0, in.length);
        inorder(root);
    }

    static void inorder(Node n) {
        if (n == null)
            return;
        inorder(n.left);
        System.out.println(n.key);
        inorder(n.right);
    }

    static void preorder(Node n) {
        if (n == null)
            return;
        System.out.println(n.key);
        preorder(n.left);
        preorder(n.right);
    }

    static void postorder(Node n) {
        if (n == null)
            return;
        postorder(n.left);
        postorder(n.right);
        System.out.println(n.key);
    }

    static void levelorder(Node n) {
        int h = height(n);
        for (int i = 1; i <= h; i++)
            printLevel(n, i);
    }

    static int height(Node n) {
        if (n == null)
            return 0;
        /*else {
            int lh = height(n.left);
            int rh = height(n.right);
            if (lh > rh)
                return lh + 1;
            else
                return rh + 1;
        }*/
        return (1 + Math.max(height(n.left), height(n.right)));
    }

    static void printLevel(Node n, int level) {
        if (n == null)
            return;
        if (level == 1)
            System.out.println(n.key);
        else {
            printLevel(n.left, level - 1);
            printLevel(n.right, level - 1);
        }
    }

    static int size(Node n) {
        if (n == null)
            return 0;
        else
            return (size(n.left) + 1 + size(n.right));
    }

    static int findMax(Node n) {
        if (n == null)
            return Integer.MIN_VALUE;
        int val = n.key;
        int lval = findMax(n.left);
        int rval = findMax(n.right);
        if (lval > val)
            val = lval;
        if (rval > val)
            val = rval;
        return val;
    }

    static int findMin(Node n) {
        if (n == null)
            return Integer.MAX_VALUE;
        int val = n.key;
        int lval = findMin(n.left);
        int rval = findMin(n.right);
        if (lval < val)
            val = lval;
        if (rval < val)
            val = rval;
        return val;
    }

    static int diameter(Node n) {
        if (n == null)
            return 0;
        int lh = height(n.left);
        int rh = height(n.right);

        int ld = diameter(n.left);
        int rd = diameter(n.right);

        return Math.max(lh + rh, Math.max(ld, rd));
    }

    static void inorderStack(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Node n = root;

        while (n != null) {
            s.push(n);
            n = n.left;
        }

        while (s.size() > 0) {
            n = s.pop();
            System.out.println(n.key);
            if (n.right != null) {
                n = n.right;
                while (n != null) {
                    s.push(n);
                    n = n.left;
                }
            }
        }
    }

    Node buildTree(char[] in, char[] pre, int s, int e) {
        if (s > e)
            return null;
        Node tNode = new Node(pre[preIndex++]);
        if (s == e)
            return tNode;
        int inIndex = search(in, s, e, tNode.key);
        tNode.left = buildTree(in, pre, s, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, e);
        return tNode;
    }

    int search(char[] in, int s, int e, int val) {
        int i;
        for (i = s; i <= e; i++) {
            if (in[i] == val)
                return i;
        }
        return i;
    }
}

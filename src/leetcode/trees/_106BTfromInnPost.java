package leetcode.trees;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _106BTfromInnPost {
    static TreeNode construct(int[] in, int is, int ie, int[] p, int ps, int pe) {
        if (is > ie || ps > pe)
            return null;

        int val = p[pe];
        TreeNode root = new TreeNode(val);

        int k = 0;
        for (int i = 0; i < in.length; i++)
            if (in[i] == val) {
                k = i;
                break;
            }

        root.left = construct(in, is, k - 1, p, ps, ps + k - (is + 1));
        root.right = construct(in, k + 1, ie, p, ps + k - is, pe - 1);
        return root;
    }

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        int iStart = 0, pStart = 0;
        int iEnd = inorder.length - 1;
        int pEnd = postorder.length - 1;
        return construct(inorder, iStart, iEnd, postorder, pStart, pEnd);
    }
}

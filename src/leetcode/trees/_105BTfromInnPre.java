package leetcode.trees;

/**
 * Created by nagabharan on 30-Sep-16.
 */
public class _105BTfromInnPre {
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        int is = 0, ps = 0;
        int ie = inorder.length - 1;
        int pe = preorder.length - 1;
        return construct(preorder, ps, pe, inorder, is, ie);
    }

    static TreeNode construct(int[] p, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe || is > ie)
            return null;

        int val = p[ps];
        TreeNode root = new TreeNode(val);

        int k = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == val) {
                k = i;
                break;
            }
        }

        root.left = construct(p, ps + 1, ps + k - is, in, is, k - 1);
        root.right = construct(p, ps + k - is + 1, pe, in, k + 1, ie);
        return root;
    }
}

package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class TreeAmplitude {
    public int sol(TN root) {
        if (root == null) return 0;
        return helper(root, root.val, root.val);
    }

    public int helper(TN r, int min, int max) {
        if (r == null) return max - min;
        if (r.val < min) min = r.val;
        if (r.val > max) max = r.val;
        return Math.max(helper(r.left, min, max), helper(r.right, min, max));
    }
}

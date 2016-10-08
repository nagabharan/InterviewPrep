package leetcode.trees;

/**
 * Created by nagabharan on 07-Oct-16.
 */
public class _96UniqueBST {
    public int numTrees(int n) {
        int[] c = new int[n + 1];
        c[0] = 1;
        c[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                c[i] = c[i] + c[j] * c[i - j - 1];
            }
        }
        return c[n];
    }
}

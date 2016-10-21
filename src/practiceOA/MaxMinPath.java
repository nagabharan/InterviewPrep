package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class MaxMinPath {
    private int min, max, r, c;

    public int mmp(int[][] mat) {
        r = mat.length;
        c = mat[0].length;
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
        dfs(mat, min, 0, 0);
        return max;
    }

    public void dfs(int[][] mat, int min, int i, int j) {
        if (i >= r || j >= c) return;
        if (i == r - 1 && j == c - 1) {
            min = Math.min(min, mat[i][j]);
            max = Math.max(max, min);
            return;
        }
        min = Math.min(min, mat[i][j]);
        dfs(mat, min, i, j + 1);
        dfs(mat, min, i + 1, j);
    }
}

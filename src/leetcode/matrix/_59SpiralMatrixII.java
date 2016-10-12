package leetcode.matrix;

/**
 * Created by nagabharan on 11-Oct-16.
 */
public class _59SpiralMatrixII {
    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        if (n == 0)
            return res;

        int k = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (k <= n * n) {

            for (int i = left; i <= right; i++) {
                res[top][i] = k;
                k++;
            }

            top++;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = k;
                k++;
            }

            right--;

            if (bottom < top)
                break;

            for (int i = right; i >= left; i--) {
                res[bottom][i] = k;
                k++;
            }
            bottom--;

            if (right < left)
                break;

            for (int i = bottom; i >= top; i--) {
                res[i][left] = k;
                k++;
            }

            left++;

        }

        return res;
    }

}

package leetcode.matrix;

/**
 * Created by nagabharan on 11-Oct-16.
 */
public class _48RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil((double) n / 2.0); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}

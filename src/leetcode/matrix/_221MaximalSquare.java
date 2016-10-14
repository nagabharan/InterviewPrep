package leetcode.matrix;

/**
 * Created by nagabharan on 13-Oct-16.
 */
public class _221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = Character.getNumericValue(matrix[i][0]);

        for (int i = 0; i < n; i++)
            dp[0][i] = Character.getNumericValue(matrix[0][i]);

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }

        int max = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > max)
                    max = dp[i][j];
            }

        return max * max;
    }
}

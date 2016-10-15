package leetcode.matrix;

/**
 * Created by nagabharan on 14-Oct-16.
 */
public class _329LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] mem = new int[m][n];

        int longest = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                longest = Math.max(longest, dfs(matrix, i, j, mem));

        return longest;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] mem) {

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        if (mem[i][j] != 0)
            return mem[i][j];

        for (int k = 0; k < 4; k++) {
            int nx = i + x[k];
            int ny = j + y[k];

            if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && matrix[nx][ny] > matrix[i][j])
                mem[i][j] = Math.max(mem[i][j], dfs(matrix, nx, ny, mem));
        }

        return ++mem[i][j];

    }
}

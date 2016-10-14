package leetcode.matrix;

/**
 * Created by nagabharan on 13-Oct-16.
 */
public class _200NumberOfIslands {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;

        int c = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    c++;
                    merge(grid, i, j);
                }
            }

        return c;
    }

    public void merge(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1')
            return;

        grid[i][j] = '#';

        merge(grid, i - 1, j);
        merge(grid, i + 1, j);
        merge(grid, i, j - 1);
        merge(grid, i, j + 1);
    }
}

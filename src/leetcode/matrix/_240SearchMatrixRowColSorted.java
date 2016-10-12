package leetcode.matrix;

/**
 * Created by nagabharan on 11-Oct-16.
 */
public class _240SearchMatrixRowColSorted {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        int i = m, j = 0;

        while (i >= 0 && j <= n) {
            if (target < matrix[i][j])
                i--;
            else if (target > matrix[i][j])
                j++;
            else
                return true;
        }

        return false;
    }
}

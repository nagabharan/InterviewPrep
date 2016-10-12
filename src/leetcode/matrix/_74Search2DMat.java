package leetcode.matrix;

/**
 * Created by nagabharan on 11-Oct-16.
 */
public class _74Search2DMat {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int s = 0, e = m * n - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            int mx = mid / n;
            int my = mid % n;

            if (matrix[mx][my] == target)
                return true;

            if (matrix[mx][my] < target)
                s = mid + 1;
            else
                e = mid - 1;

        }
        return false;
    }
}

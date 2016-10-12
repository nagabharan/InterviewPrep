package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 11-Oct-16.
 */
public class _54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;

        int m = matrix.length, n = matrix[0].length;

        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (res.size() < m * n) {

            for (int i = left; i <= right; i++)
                res.add(matrix[top][i]);

            top++;

            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);

            right--;

            if (bottom < top)
                break;

            for (int i = right; i >= left; i--)
                res.add(matrix[bottom][i]);

            bottom--;

            if (right < left)
                break;

            for (int i = bottom; i >= top; i--)
                res.add(matrix[i][left]);

            left++;

        }

        return res;
    }
}

package leetcode.matrix;

import java.util.Stack;

/**
 * Created by nagabharan on 13-Oct-16.
 */
public class _85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;

        int[][] ht = new int[m][n + 1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0')
                    ht[i][j] = 0;
                else
                    ht[i][j] = i == 0 ? 1 : ht[i - 1][j] + 1;
            }

        int max = 0;

        for (int i = 0; i < m; i++) {
            int ma = maxAreainHist(ht[i]);
            if (ma > max)
                max = ma;
        }
        return max;
    }

    public int maxAreainHist(int[] ht) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, max = 0;

        while (i < ht.length) {
            if (stack.isEmpty() || ht[stack.peek()] <= ht[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, ht[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }
}

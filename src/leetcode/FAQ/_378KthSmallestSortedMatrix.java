package leetcode.FAQ;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _378KthSmallestSortedMatrix {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int l = mat[0][0], u = mat[m - 1][m - 1];

        while (l < u) {
            int mid = l + (u - l) >> 1;
            int c = count(mat, mid);
            if (c < k)
                l = mid + 1;
            else
                u = mid;
        }
        return u;
    }

    public int count(int[][] mat, int t) {
        int m = mat.length;
        int i = m - 1, j = 0, c = 0;

        while (i >= 0 && j < m) {
            if (mat[i][j] <= t) {
                j++;
                c += i + 1;
            } else {
                i--;
            }
        }
        return c;
    }
}

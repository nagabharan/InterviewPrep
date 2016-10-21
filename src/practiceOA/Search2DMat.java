package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class Search2DMat {
    public Point inMat(int[][] mat, int target) {
        int row = mat.length;
        int col = mat[0].length;
        int r = 0;
        int c = col - 1;
        while (r < row && c >= 0) {
            if (mat[r][c] == target)
                return new Point(r, c);
            if (mat[r][c] > target)
                c--;
            else
                r++;
        }
        return new Point(-1, -1);
    }
}

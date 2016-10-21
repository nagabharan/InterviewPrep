package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class Maze {
    public static int ratmaze(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return 0;
        if (mat[0][0] == 9)
            return 1;
        return findPath(mat, 0, 0);
    }

    public static int findPath(int[][] mat, int x, int y) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat.length)
            return 0;
        if (mat[x][y] == 9)
            return 1;
        if (mat[x][y] != 1)
            return 0;

        if (mat[x][y] == 1)
            mat[x][y] = 3;

        if (findPath(mat, x - 1, y) == 1)
            return 1;

        if (findPath(mat, x, y + 1) == 1)
            return 1;

        if (findPath(mat, x + 1, y) == 1)
            return 1;

        if (findPath(mat, x, y - 1) == 1)
            return 1;

        mat[x][y] = 0;
        return 0;
    }

    public static void main(String[] args) {
        int maze[][] = {{1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 9, 0, 1, 1},
                {1, 1, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(ratmaze(maze));
    }
}

package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class RotateMatrix {
    public static int[][] rotate(int[][] mat, int flag) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return mat;
        if (flag == 1) {
            rotateR(mat);
        } else {
            rotateL(mat);
        }
        return mat;
    }

    public static void rotateL(int[][] mat) {
        transpose(mat);
        swapRows(mat);
    }

    public static void rotateR(int[][] mat) {
        swapRows(mat);
        transpose(mat);
    }

    public static void transpose(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[0].length; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
    }

    public static void swapRows(int[][] mat) {
        for (int i = 0, k = mat.length - 1; i < k; ++i, --k) {
            int[] t = mat[i];
            mat[i] = mat[k];
            mat[k] = t;
        }
    }

    public static void printMat(int[][] e) {
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < e[i].length; j++) {
                System.out.print(e[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] e = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMat(e);
        rotate(e, 0);
        printMat(e);
        rotate(e, 1);
        printMat(e);
    }
}

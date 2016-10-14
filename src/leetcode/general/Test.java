package leetcode.general;

/**
 * Created by nagabharan on 12-Oct-16.
 */
public class Test {
    static void StairCase(int n) {

        for (int i = 1; i <= n; i++) {
            int j, k;
            for (j = n - i; j >= 0; j--)
                System.out.print(" ");

            for (k = 1; k <= j - n + i; k++)
                System.out.print("#");

            System.out.println();

        }
    }

    public static void main(String[] args) {
        StairCase(6);
    }
}

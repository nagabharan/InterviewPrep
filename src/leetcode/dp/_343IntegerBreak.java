package leetcode.dp;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _343IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        if (n == 4)
            return 4;

        int res = 1;
        if (n % 3 == 0) {
            int m = n / 3;
            res = (int) Math.pow(3, m);
        } else if (n % 3 == 2) {
            int m = n / 3;
            res = (int) Math.pow(3, m) * 2;
        } else if (n % 3 == 1) {
            int m = (n - 4) / 3;
            res = (int) Math.pow(3, m) * 4;
        }
        return res;
    }
}

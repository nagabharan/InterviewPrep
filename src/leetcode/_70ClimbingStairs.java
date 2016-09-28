package leetcode;

/**
 * Created by nagabharan on 27-Sep-16.
 */
public class _70ClimbingStairs {
    static int climbStairs(int n) {
        int f1 = 2;
        int f2 = 1;
        if (n == 1)
            return f2;
        else if (n == 2)
            return f1;
        int fn = 0;
        for (int i = 3; i <= n; i++) {
            fn = f1 + f2;
            f2 = f1;
            f1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}

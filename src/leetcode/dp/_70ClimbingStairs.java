package leetcode.dp;

/**
 * Created by nagabharan on 15-Oct-16.
 */
public class _70ClimbingStairs {
    int[] dp = new int[100];

    public int climbStairs(int n) {
        if (n <= 2)
            dp[n] = n;

        if (dp[n] > 0)
            return dp[n];
        else
            dp[n] = climbStairs(n - 1) + climbStairs(n - 2);

        return dp[n];
    }
}

package leetcode.dp;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _322CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++)
            dp[i] = amount + 1;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i)
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

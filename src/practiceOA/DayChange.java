package practiceOA;

import java.util.Arrays;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class DayChange {
    public int[] dayChange(int[] days, int n) {
        if (days == null || n <= 0) return days;
        int len = days.length;
        int[] dp = new int[len + 2];
        dp[0] = dp[len + 1] = 0;
        int pre = dp[0];
        for (int i = 1; i <= len; i++)
            dp[i] = days[i - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= len; j++) {
                int temp = dp[j];
                dp[j] = pre ^ dp[j + 1];
                pre = temp;
            }
        }
        return Arrays.copyOfRange(dp, 1, len + 1);
    }
}

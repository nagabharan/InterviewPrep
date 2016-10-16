package leetcode.dp;

import java.util.Set;

/**
 * Created by nagabharan on 15-Oct-16.
 */
public class _139WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!dp[i])
                continue;

            for (String a : wordDict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length())
                    continue;
                if (dp[end])
                    continue;
                if (s.substring(i, end).equals(a))
                    dp[end] = true;
            }
        }
        return dp[s.length()];
    }
}

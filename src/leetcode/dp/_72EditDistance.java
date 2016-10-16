package leetcode.dp;

/**
 * Created by nagabharan on 15-Oct-16.
 */
public class _72EditDistance {
    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null && word1.length() == 0 && word2.length() == 0)
            return 0;
        if (word1 == null && word2 != null && word2.length() > 0)
            return word2.length();
        if (word1 != null && word2 == null && word1.length() > 0)
            return word1.length();
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++)
            dp[i][0] = i;

        for (int j = 0; j <= l2; j++)
            dp[0][j] = j;

        for (int i = 0; i < l1; i++) {
            char x = word1.charAt(i);
            for (int j = 0; j < l2; j++) {
                char y = word2.charAt(j);

                if (x == y) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int rep = dp[i][j] + 1,
                            del = dp[i][j + 1] + 1,
                            add = dp[i + 1][j] + 1;
                    int min = rep < del ? rep : del;
                    min = min < add ? min : add;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("", "a"));
    }
}

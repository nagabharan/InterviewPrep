package leetMS;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _5LongestPalSubStr {
    public static String sol(String s) {
        if (s == null || s.length() <= 1)
            return s;

        int len = s.length();
        int max = 1;
        boolean[][] dp = new boolean[len][len];
        String res = null;

        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;

                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sol("bad"));
    }
}

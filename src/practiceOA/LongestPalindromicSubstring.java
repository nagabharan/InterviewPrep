package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class LongestPalindromicSubstring {
    public static String lPS(String s) {
        if (s == null || s.length() == 0) return s;

        int len = s.length();
        int maxlen = 1;
        boolean[][] dp = new boolean[len][len];
        String res = null;
        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxlen) {
                        maxlen = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lPS("abbadab"));
    }
}

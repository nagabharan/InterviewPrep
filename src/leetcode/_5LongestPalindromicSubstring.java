package leetcode;

/**
 * Created by nagabharan on 27-Sep-16.
 */
public class _5LongestPalindromicSubstring {
    static String longestPalindrome(String s) {
        if (s.isEmpty())
            return null;
        if (s.length() == 1)
            return s;

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String tmp = util(s, i, i);
            if (tmp.length() > longest.length())
                longest = tmp;
            tmp = util(s, i, i + 1);
            if (tmp.length() > longest.length())
                longest = tmp;
        }
        return longest;
    }

    static String util(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("dabcba"));
    }
}

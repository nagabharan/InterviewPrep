package leetcode.FAQ;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _389FindTheDifference {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}

package leetcode;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _58LengthOfLastWord {
    static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int i = s.length() - 1;
        int cnt = 0;
        while (i >= 0) {
            if (Character.isWhitespace(s.charAt(i))) {
                if (cnt != 0)
                    return cnt;
            } else if (Character.isAlphabetic(s.charAt(i))) {
                cnt++;
            }
            i--;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
}

package leetcode.general;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _28strStr {
    static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null)
            return 0;

        if (needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length())
                return -1;

            int tmp = i;

            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) == haystack.charAt(tmp)) {
                    if (j == needle.length() - 1)
                        return i;
                    tmp++;
                } else
                    break;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        String needle = "her";
        String haystack = "there";
        System.out.println(strStr(haystack, needle));
    }
}

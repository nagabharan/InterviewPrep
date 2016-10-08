package leetcode.general;

/**
 * Created by nagabharan on 27-Sep-16.
 */
public class _14LongestCommonPrefix {
    static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int minlenstr = strs.length + 1;
        for (String str : strs) {
            if (minlenstr > str.length())
                minlenstr = str.length();
        }
        for (int i = 0; i < minlenstr; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                String s1 = strs[j];
                String s2 = strs[j + 1];
                if (s1.charAt(i) != s2.charAt(i))
                    return s1.substring(0, i);
            }
        }
        return strs[0].substring(0, minlenstr);
    }

    public static void main(String[] args) {
        String[] strs = {"Hello", "He"};
        System.out.println(longestCommonPrefix(strs));
    }
}

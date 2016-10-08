package leetcode.general;

/**
 * Created by nagabharan on 29-Sep-16.
 */
public class _151ReverseWordsInAString {

    static String reverseWords(String s) {

        if (s == null || s.length() == 0)
            return "";

        String[] tokens = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (!tokens[i].equals(""))
                sb.append(tokens[i]).append(" ");
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}

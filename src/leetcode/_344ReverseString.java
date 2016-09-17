package leetcode;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class _344ReverseString {
    public static String reverseStr(String s) {
        char[] in = s.toCharArray();
        int j = s.length() - 1;
        int i = 0;
        while (j > i) {
            char tmp = in[i];
            in[i] = in[j];
            in[j] = tmp;
            i++;
            j--;
        }
        return new String(in);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("hello"));
    }
}

package leetcode;

/**
 * Created by nagabharan on 16-Sep-16.
 */
public class _8StringToInt {
    public static int myAtoI(String s) {
        int maxval = Integer.MAX_VALUE / 10;
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        int sign = 1;
        if (i < n && s.charAt(i) == '+') i++;
        else if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = Character.getNumericValue(s.charAt(i));
            if (num > maxval || num == maxval && d >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + d;
            i++;
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return sign * num;
    }

    public static void main(String[] args) {
        String s = "      920 ";
        System.out.println(myAtoI(s));
    }
}

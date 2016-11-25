package leetMS;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _8atoi {
    public int sol(String s) {
        if (s == null || s.length() < 1)
            return 0;

        s = s.trim();

        char flag = '+';
        int i = 0;

        double res = 0;

        if (s.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (s.charAt(0) == '+')
            i++;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            res = res * 10 + (s.charAt(i) - '0');
            i++;
        }
        if (flag == '-')
            res = -res;

        if (res > Integer.MAX_VALUE)
            res = Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE)
            res = Integer.MIN_VALUE;

        return (int) res;
    }
}

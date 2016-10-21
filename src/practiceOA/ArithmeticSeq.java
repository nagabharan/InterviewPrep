package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class ArithmeticSeq {
    public static int getNAS(int[] a) {
        if (a.length < 3) return 0;

        int res = 0;
        int diff = Integer.MIN_VALUE;
        int c = 0;
        int start = 0;

        for (int i = 1; i < a.length; i++) {
            int cd = a[i] - a[i - 1];
            if (diff == cd)
                c += i - start - 1 > 0 ? i - start - 1 : 0;
            else {
                start = i - 1;
                diff = cd;
                res += c;
                c = 0;
            }
        }
        res += c;
        return res;
    }
}

package leetcode.FAQ;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _342PowOf4 {
    public boolean isPowerOfFour(int n) {
        if (n == 0)
            return false;
        return n == Math.pow(4, Math.round(Math.log(n) / Math.log(4)));
    }
}

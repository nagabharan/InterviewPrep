package leetcode.FAQ;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _326PowOf3 {
    public boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;
        return n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}

package leetcode.FAQ;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _371SumOfTwoIntegers {
    public static int getSum(int a, int b) {
        while (b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(5, 8));
    }
}

package leetcode.general;

/**
 * Created by nagabharan on 16-Sep-16.
 */
public class _7ReverseInt {
    public static int reverse(int x) {
        /**
         * int n = Math.abs(x);
         long result = 0;

         while (n != 0) {
         result = (result * 10) + (n % 10);
         n = n / 10;
         }

         if (x < 0) {
         result = result * -1;
         }

         if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
         return 0;
         }
         return (int) result;
         */
        int rev = 0;
        int max = 1 << 31;

        while (x != 0) {
            /*if (rev != 0 && max / rev < 10 && max / rev > -10)
                return 0;*/
            if (rev != 0 && Math.abs(rev) > Integer.MAX_VALUE / 10)
                return 0;
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x < 0 ? 0 - rev : rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(0));
        System.out.println(reverse(-10));
        System.out.println(reverse(1534236469));
    }
}

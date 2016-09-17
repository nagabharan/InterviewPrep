package leetcode;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class _9PalindromeNumber {
    public static boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r)
                return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1331));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(53));
    }
}

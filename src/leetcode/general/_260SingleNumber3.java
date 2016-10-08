package leetcode.general;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class _260SingleNumber3 {
    public static int[] single(int[] nums) {
        int a = 0, b = 0, axorb = 0;
        for (int i : nums) {
            axorb ^= i;
        }
        axorb = (axorb & (axorb - 1)) ^ axorb;
        for (int i : nums) {
            if ((axorb & i) == 0)
                a ^= i;
            else
                b ^= i;
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4, 4, 5};
        for (int i : single(nums))
            System.out.println(i);
    }
}

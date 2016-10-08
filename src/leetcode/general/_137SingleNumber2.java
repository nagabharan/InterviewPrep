package leetcode.general;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class _137SingleNumber2 {
    public static int single(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i : nums) {
            twos |= ones & i;
            ones ^= i;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3, 3, 3, 4};
        System.out.println(single(nums));
    }
}

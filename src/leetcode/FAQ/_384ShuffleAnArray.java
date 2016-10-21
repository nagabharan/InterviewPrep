package leetcode.FAQ;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _384ShuffleAnArray {

    int[] orig;
    int[] shuf;
    Random r;

    public _384ShuffleAnArray(int[] nums) {
        orig = nums;
        shuf = Arrays.copyOf(nums, nums.length);
        r = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        shuf = Arrays.copyOf(orig, orig.length);
        return shuf;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int len = shuf.length;
        for (int i = 0; i < len; i++) {
            int si = r.nextInt(len - i);
            int temp = shuf[si];
            shuf[i] = shuf[si + i];
            shuf[si + i] = temp;
        }
        return shuf;
    }
}

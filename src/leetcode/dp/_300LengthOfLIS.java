package leetcode.dp;

import java.util.Arrays;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _300LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;

        int[] max = new int[nums.length];
        int res = 1;
        Arrays.fill(max, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    max[i] = Math.max(max[i], max[j] + 1);
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }
}

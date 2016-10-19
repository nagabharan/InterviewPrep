package leetcode.dp;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _376WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length < 2)
            return nums.length;

        int c = 1;
        for (int i = 1, j = 0; i < nums.length; j = i, i++) {
            if (nums[i] > nums[j]) {
                c++;
                while (i < nums.length - 1 && nums[i] <= nums[i + 1])
                    i++;
            } else if (nums[i] < nums[j]) {
                c++;
                while (i < nums.length - 1 && nums[i] >= nums[i + 1])
                    i++;
            }
        }
        return c;
    }
}

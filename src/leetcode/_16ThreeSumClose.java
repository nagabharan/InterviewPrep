package leetcode;

import java.util.Arrays;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class _16ThreeSumClose {
    public static int threesumclose(int[] nums, int t) {
        int min = Integer.MAX_VALUE;
        int res = 0;

        if (nums.length < 3 || nums == null)
            return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(sum - t);
                    if (diff == 0)
                        return sum;
                    if (diff < min) {
                        min = diff;
                        res = sum;
                    } else if (sum <= t)
                        j++;
                    else
                        k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {-1, 2, 1, -4};
        System.out.println(threesumclose(num, 1));
    }
}

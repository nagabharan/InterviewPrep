package leetcode.general;

/**
 * Created by nagabharan on 16-Sep-16.
 */
public class _167TwoSumSorted {
    public static void main(String[] args) {
        int[] num = {2, 3, 4};
        for (int i : twoSum(num, 6)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("No Two Sum Solution");
    }
}

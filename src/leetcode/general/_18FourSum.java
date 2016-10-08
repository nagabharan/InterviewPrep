package leetcode.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class _18FourSum {
    public static List<List<Integer>> fourSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4)
            return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] > nums[j - 1]) {
                        int k = j + 1;
                        int l = nums.length - 1;

                        while (k < l) {
                            if (nums[i] + nums[j] + nums[k] + nums[l] == 0) {
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[k]);
                                list.add(nums[l]);
                                res.add(list);

                                k++;
                                l--;

                                //duplicates
                                while (k < l && nums[k] == nums[k - 1])
                                    k++;
                                while (k < l && nums[l] == nums[l + 1])
                                    l--;

                            } else if (nums[i] + nums[j] + nums[k] + nums[l] < 0) {
                                k++;
                            } else {
                                l--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(num).toString());
    }
}

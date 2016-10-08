package leetcode.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nagabharan on 16-Sep-16.
 */
public class _1TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x), i};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] num = {3, 2, 4};
        for (int i : twoSum(num, 6)) {
            System.out.println(i);
        }
    }
}

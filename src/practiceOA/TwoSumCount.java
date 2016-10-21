package practiceOA;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class TwoSumCount {
    public static int tsc(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                c += map.get(target - nums[i]);
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i]) + 1);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(tsc(new int[]{1, 2, 3, 4}, 5));
    }
}

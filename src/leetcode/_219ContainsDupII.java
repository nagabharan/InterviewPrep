package leetcode;

import java.util.HashMap;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _219ContainsDupII {
    static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int pre = map.get(nums[i]);
                if (i - pre <= k)
                    return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 3};
        System.out.println(containsNearbyDuplicate(arr, 1));
    }
}

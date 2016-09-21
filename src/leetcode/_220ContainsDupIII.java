package leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _220ContainsDupIII {
    static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 0 || t < 0)
            return false;

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long curr = (long) nums[i];
            long left = curr - t;
            long right = curr + t + 1;
            SortedSet<Long> sub = set.subSet(left, right);
            if (sub.size() > 0)
                return true;

            set.add(curr);

            if (i >= k)
                set.remove((long) nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 3, 2};
        System.out.println(containsNearbyAlmostDuplicate(arr, 1, 1));
    }
}

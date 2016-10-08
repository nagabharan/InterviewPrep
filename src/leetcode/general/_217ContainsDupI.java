package leetcode.general;

import java.util.HashSet;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _217ContainsDupI {
    static boolean containsDuplicate(int[] nums) {

        if (nums.length == 0 || nums == null)
            return false;

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 3, 2};
        System.out.println(containsDuplicate(arr));
    }
}

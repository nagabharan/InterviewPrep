package leetMS;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _1TwoSum {
    public static int[] sol(int[] nums, int t) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                int in = m.get(nums[i]);
                res[0] = in;
                res[1] = i;
                break;
            } else {
                m.put(t - nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n = {2, 7, 11, 15};
        System.out.println(Arrays.toString(sol(n, 13)));
    }
}

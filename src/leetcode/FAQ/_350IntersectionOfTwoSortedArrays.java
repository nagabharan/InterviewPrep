package leetcode.FAQ;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _350IntersectionOfTwoSortedArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> m1 = new HashMap<>();
        for (int i : nums1) {
            if (m1.containsKey(i))
                m1.put(i, m1.get(i) + 1);
            else
                m1.put(i, 1);
        }

        ArrayList<Integer> l = new ArrayList<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();
        for (int i : nums2) {
            if (m1.containsKey(i)) {
                if (m1.get(i) > 1)
                    m1.put(i, m1.get(i) - 1);
                else
                    m1.remove(i);
                l.add(i);
            }
        }

        int[] res = new int[l.size()];
        int i = 0;
        for (int n : l) {
            res[i++] = n;
        }
        return res;
    }
}

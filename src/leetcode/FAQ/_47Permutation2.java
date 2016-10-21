package leetcode.FAQ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _47Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0 || nums == null) return res;

        res.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            Set<ArrayList<Integer>> cur = new HashSet<>();
            for (List<Integer> l : res) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, nums[i]);
                    ArrayList<Integer> t = new ArrayList<>(l);
                    cur.add(t);
                    l.remove(j);
                }
            }
            res = new ArrayList<List<Integer>>(cur);
        }

        return res;
    }
}

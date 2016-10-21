package leetcode.FAQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _90Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> prev = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length - 1 || prev.size() == 0 || nums[i] != nums[i + 1]) {
                prev = new ArrayList<List<Integer>>();
                for (int j = 0; j < res.size(); j++)
                    prev.add(new ArrayList<Integer>(res.get(j)));
            }
            for (List<Integer> l : prev) {
                l.add(0, nums[i]);
            }

            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                List<Integer> t = new ArrayList<>();
                t.add(nums[i]);
                prev.add(t);
            }
            for (List<Integer> l : prev)
                res.add(new ArrayList<Integer>(l));
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
}

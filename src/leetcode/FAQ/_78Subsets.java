package leetcode.FAQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            ArrayList<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> a : res) {
                temp.add(new ArrayList<Integer>(a));
            }
            for (List<Integer> a : temp) {
                a.add(nums[i]);
            }
            List<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            temp.add(single);
            res.addAll(temp);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
}

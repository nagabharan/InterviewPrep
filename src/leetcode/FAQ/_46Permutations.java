package leetcode.FAQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _46Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            ArrayList<ArrayList<Integer>> curr = new ArrayList<>();
            for (List<Integer> l : res) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, nums[i]);
                    ArrayList<Integer> temp = new ArrayList<>(l);
                    curr.add(temp);
                    l.remove(j);
                }
            }
            res = new ArrayList<List<Integer>>(curr);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}

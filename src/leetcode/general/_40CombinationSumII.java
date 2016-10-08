package leetcode.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _40CombinationSumII {
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0 || candidates == null)
            return result;

        ArrayList<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);

        utilFunc(candidates, target, 0, curr, result);

        return result;
    }

    static void utilFunc(int[] candidates, int target, int j, ArrayList<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(curr);
            result.add(temp);
            return;
        }
        int prev = -1;
        for (int i = j; i < candidates.length; i++) {
            if (target < candidates[i])
                return;
            if (prev != candidates[i]) {
                curr.add(candidates[i]);
                utilFunc(candidates, target - candidates[i], i + 1, curr, result);
                curr.remove(curr.size() - 1);
                prev = candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7};
        System.out.println(combinationSum2(arr, 7).toString());
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _39CombinationSum {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for (int i = j; i < candidates.length; i++) {
            if (target < candidates[i])
                return;
            curr.add(candidates[i]);
            utilFunc(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7};
        System.out.println(combinationSum(arr, 7).toString());
    }
}

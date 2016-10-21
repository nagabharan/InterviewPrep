package leetcode.FAQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || n < k) return res;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list, res);
        return res;
    }

    public void dfs(int n, int k, int start, ArrayList<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}

package leetcode.FAQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _118PascalsTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0)
            return res;

        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        res.add(pre);

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++)
                cur.add(pre.get(j) + pre.get(j + 1));
            cur.add(1);
            res.add(cur);
            pre = cur;
        }
        return res;
    }
}

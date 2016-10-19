package leetcode.FAQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _119PascalTriangleRow {
    public List<Integer> getRow(int k) {
        List<Integer> res = new ArrayList<>();
        if (k < 0)
            return res;
        res.add(1);
        for (int i = 1; i <= k; i++) {
            for (int j = res.size() - 2; j >= 0; j--) {
                res.set(j + 1, res.get(j) + res.get(j + 1));
            }
            res.add(1);
        }
        return res;
    }
}

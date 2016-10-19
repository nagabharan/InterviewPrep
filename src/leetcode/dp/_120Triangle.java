package leetcode.dp;

import java.util.List;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return triangle.get(0).get(0);

        for (int i = triangle.size() - 2; i >= 0; i--) {
            int s = triangle.get(i).size();
            for (int j = 0; j < s; j++) {
                int min = Math.min(triangle.get(i).get(j) + triangle.get(i + 1).get(j),
                        triangle.get(i).get(j) + triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }
}

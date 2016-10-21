package practiceOA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class WindowSum {
    public static List<Integer> getSum(List<Integer> a, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (a == null || a.size() == 0) return res;
        int c = 0;
        for (int i = 0; i < a.size(); i++) {
            c++;
            if (c >= k) {
                int sum = 0;
                for (int j = i; j >= i - k + 1; j--)
                    sum += a.get(j);
                res.add(sum);
            }
        }
        return res;
    }
}

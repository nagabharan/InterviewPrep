package leetMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _15ThreeSum {
    public List<List<Integer>> sol(int[] nos) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nos == null || nos.length < 3)
            return res;

        Arrays.sort(nos);

        for (int i = 0; i < nos.length - 2; i++) {
            if (i == 0 || nos[i] > nos[i - 1]) {
                int j = i + 1;
                int k = nos.length;

                while (j < k) {
                    if (nos[i] + nos[j] + nos[k] == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nos[i]);
                        l.add(nos[j]);
                        l.add(nos[k]);
                        res.add(l);
                        j++;
                        k--;

                        while (j < k && nos[j] == nos[j - 1])
                            j++;
                        while (j < k && nos[k] == nos[k + 1])
                            k--;
                    } else if (nos[i] + nos[j] + nos[k] < 0) j++;
                    else k--;
                }
            }
        }

        return res;
    }
}

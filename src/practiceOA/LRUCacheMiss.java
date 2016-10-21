package practiceOA;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class LRUCacheMiss {
    public int missCount(int[] arr, int size) {
        if (arr == null) return 0;
        List<Integer> cache = new LinkedList<>();
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cache.contains(arr[i]))
                cache.remove(new Integer(arr[i]));
            else {
                c++;
                if (cache.size() == size)
                    cache.remove(0);
            }
            cache.add(arr[i]);
        }
        return c;
    }
}

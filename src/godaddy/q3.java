package godaddy;

import java.util.HashMap;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class q3 {
    static int countDuplicates(int[] numbers) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : numbers) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : map.values()) {
            if (i > 1)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 4, 5, 6, 3, 2};
        System.out.println(countDuplicates(nums));
        int[] num = {1, 1, 2, 2, 2, 3};
        System.out.println(countDuplicates(num));
    }
}

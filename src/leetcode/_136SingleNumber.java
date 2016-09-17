package leetcode;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class _136SingleNumber {
    public static int single(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : arr) {
            if (!set.add(n))
                set.remove(n);
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }

    public static void main(String[] args) {
        int[] num = {2, 2, 3, 3, 4, 4, 5, 5, 1};
        System.out.println(single(num));
    }
}

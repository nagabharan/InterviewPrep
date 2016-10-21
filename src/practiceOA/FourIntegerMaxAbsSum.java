package practiceOA;

import java.util.Arrays;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class FourIntegerMaxAbsSum {
    public int[] sol(int a, int b, int c, int d) {
        int[] ar = new int[4];
        ar[0] = a;
        ar[1] = b;
        ar[2] = c;
        ar[3] = d;
        Arrays.sort(ar);
        swap(ar, 0, 1);
        swap(ar, 1, 2);
        swap(ar, 0, 3);
        return ar;
    }

    private void swap(int[] ar, int i, int j) {
        ar[i] ^= ar[j];
        ar[j] ^= ar[i];
        ar[i] ^= ar[j];
    }
}

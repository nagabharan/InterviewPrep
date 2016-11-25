package leetMS;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _4Median2Sorted {
    public double sol(int[] n1, int[] n2) {
        int t = n1.length + n2.length;
        if (t % 2 == 0) {
            return (findk(t / 2 + 1, n1, n2, 0, 0) + findk(t / 2, n1, n2, 0, 0)) / 2.0;
        } else
            return findk(t / 2 + 1, n1, n2, 0, 0);
    }

    public int findk(int k, int[] n1, int[] n2, int s1, int s2) {
        if (s1 >= n1.length)
            return n2[s2 + k - 1];
        if (s2 >= n2.length)
            return n1[s1 + k - 1];
        if (k == 1)
            return Math.min(n1[s1], n2[s2]);

        int m1 = (s1 + k) / 2 - 1;
        int m2 = (s2 + k) / 2 - 1;

        int mid1 = m1 < n1.length ? n1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < n2.length ? n2[m2] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findk(k - k / 2, n1, n2, m1 + 1, s2);
        } else {
            return findk(k - k / 2, n1, n2, s1, m2 + 1);
        }
    }
}

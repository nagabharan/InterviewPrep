package leetcode.FAQ;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _396RotateFunction {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int f0 = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            f0 += A[i] * i;
            sum += A[i];
        }
        int max = f0, fi = f0;
        for (int i = 1; i < n; i++) {
            fi += sum;
            fi -= n * A[n - i];
            max = Math.max(max, fi);
        }
        return max;
    }
}

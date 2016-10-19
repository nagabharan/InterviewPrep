package leetcode.dp;

/**
 * Created by nagabharan on 18-Oct-16.
 */
public class _357NumberUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = 9;
            for (int j = 9; j >= 9 - i + 2; j--)
                arr[i] *= j;
        }

        int res = 0;
        for (int i : arr)
            res += i;

        return res;
    }
}

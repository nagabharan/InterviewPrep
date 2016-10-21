package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class GCDArray {
    public static int gcd(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++)
            gcd = getgcd(gcd, arr[i]);
        return gcd;
    }

    private static int getgcd(int a, int b) {
        if (a == 0 || b == 0) return 0;
        while (a != 0 && b != 0) {
            if (a > b) {
                a ^= b;
                b ^= a;
                a ^= b;
            }
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a + b;
    }
}

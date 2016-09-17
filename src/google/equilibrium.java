package google;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class equilibrium {
    public static int solution(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        for (int i = 0; i < a.length; i++) {
            if (sum - a[i] == 0)
                return i;
            sum -= a[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(solution(arr));
    }
}

package practiceOA;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class GrayCode {
    public static int grayCode(int term1, int term2) {
        byte x = (byte) (term1 ^ term2);
        int total = 0;
        while (x != 0) {
            x = (byte) (x & (x - 1));
            total++;
        }
        if (total == 1) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(3, 1));
    }
}

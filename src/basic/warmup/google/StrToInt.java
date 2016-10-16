package google;

/**
 * Created by nagabharan on 15-Sep-16.
 */
public class StrToInt {
    public static int solution(int x) {
        StringBuilder sb = new StringBuilder("" + x);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 1; i < sb.length() - 1; i++) {
            if (sb.charAt(i - 1) == sb.charAt(i)) {
                if (Integer.parseInt(sb.charAt(i) + "") < Integer.parseInt(sb.charAt(i + 1) + "")) {
                    val = Integer.parseInt(sb.deleteCharAt(i - 1).toString());
                    System.out.println(val);
                    sb = new StringBuilder("" + x);
                    if (val > max) {
                        max = val;
                    }
                    if (val < min) {
                        min = val;
                    }
                }
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        return max;
    }

    public static void main(String[] args) {
        int x = 223336226;
        System.out.println("largest:" + solution(x));
    }
}

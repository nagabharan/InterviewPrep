package google;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class q1 {
    public static int solution(int X) {
        StringBuilder sb = new StringBuilder("" + X);
        int min = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 1; i < sb.length(); i++) {
            if (Integer.parseInt(sb.charAt(i) + "") >= Integer.parseInt(sb.charAt(i - 1) + "")) {
                val = Integer.parseInt(sb.deleteCharAt(i - 1).toString());
                if (val < min) {
                    min = val;
                }
                sb = new StringBuilder("" + X);
            }
        }
        return val;

    }

    public static void main(String[] args) {
        System.out.println(solution(233614));
    }
}

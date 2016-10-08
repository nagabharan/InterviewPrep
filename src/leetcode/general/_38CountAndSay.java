package leetcode.general;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _38CountAndSay {
    static String countAndSay(int n) {
        if (n < 0) return "";
        if (n < 10) return n + "";
        int i = 1;
        String in = String.valueOf(n);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (i < in.length()) {
            if (in.charAt(i) == in.charAt(i - 1)) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(in.charAt(i - 1));
                cnt = 1;
            }
            i++;
        }
        sb.append(cnt);
        sb.append(in.charAt(i - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(countAndSay(n));
    }
}

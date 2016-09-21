package leetcode;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _67AddBinary {
    static String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        if (b == null || b.length() == 0)
            return a;

        int la = a.length() - 1;
        int lb = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (la >= 0 || lb >= 0) {
            int va = 0, vb = 0;
            if (la >= 0) {
                va = Character.getNumericValue(a.charAt(la));
                la--;
            }
            if (lb >= 0) {
                vb = Character.getNumericValue(b.charAt(lb));
                lb--;
            }
            int sum = va + vb + carry;
            if (sum >= 2) {
                sb.append(String.valueOf(sum - 2));
                carry = 1;
            } else {
                sb.append(String.valueOf(sum));
                carry = 0;
            }

        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
    }
}

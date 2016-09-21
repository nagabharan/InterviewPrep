package leetcode;

import java.util.Arrays;

/**
 * Created by nagabharan on 20-Sep-16.
 */
public class _66PlusOne {
    static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return new int[0];

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            digits[i] = sum % 10;
        }

        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}

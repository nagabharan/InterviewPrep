package leetcode.FAQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _241DifferentWaysAddParentheses {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input.length() == 0 || input == null) return res;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!isOp(c))
                continue;

            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));

            for (int n1 : left) {
                for (int n2 : right) {
                    int val = calc(n1, n2, c);
                    res.add(val);
                }
            }
        }
        if (res.isEmpty())
            res.add(Integer.parseInt(input));
        return res;
    }

    public static int calc(int n1, int n2, char c) {
        int val = 0;
        switch (c) {
            case '+':
                val = n1 + n2;
                break;
            case '-':
                val = n1 - n2;
                break;
            case '*':
                val = n1 * n2;
                break;
        }
        return val;
    }

    public static boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}

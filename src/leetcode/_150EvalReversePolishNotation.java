package leetcode;

import java.util.Stack;

/**
 * Created by nagabharan on 29-Sep-16.
 */
public class _150EvalReversePolishNotation {
    static int evalRPN(String[] tokens) {
        int retVal = 0;
        String ops = "+-/*";

        Stack<String> stack = new Stack<>();

        for (String i : tokens) {
            if (!ops.contains(i)) {
                stack.push(i);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (i) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        retVal = Integer.valueOf(stack.pop());
        return retVal;
    }

    public static void main(String[] args) {
        String[] arr = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(arr));
    }
}

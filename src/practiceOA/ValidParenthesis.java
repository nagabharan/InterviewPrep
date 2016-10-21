package practiceOA;

import java.util.Stack;

/**
 * Created by nagabharan on 21-Oct-16.
 */
public class ValidParenthesis {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else if (s.charAt(i) - stack.peek() == 1 || s.charAt(i) - stack.peek() == 2)
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()(())"));
        System.out.println(isValid("([])"));
    }
}

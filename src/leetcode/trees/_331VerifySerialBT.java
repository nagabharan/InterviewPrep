package leetcode.trees;

import java.util.LinkedList;

/**
 * Created by nagabharan on 01-Oct-16.
 */
public class _331VerifySerialBT {
    static boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return false;

        LinkedList<String> stack = new LinkedList<>();
        String[] ar = preorder.split(",");

        for (int i = 0; i < ar.length; i++) {
            stack.add(ar[i]);
            while (stack.size() >= 3
                    && stack.get(stack.size() - 1).equals("#")
                    && stack.get(stack.size() - 2).equals("#")
                    && !stack.get(stack.size() - 3).equals("#")) {
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add("#");
            }
        }

        return stack.size() == 1 && stack.get(0).equals("#");
    }
}

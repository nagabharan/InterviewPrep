package leetMS;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _20ValidParenthesis {
    public boolean sol(String s) {
        HashMap<Character, Character> m = new HashMap<>();
        m.put('(', ')');
        m.put('[', ']');
        m.put('{', '}');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (m.keySet().contains(c)) {
                st.push(c);
            } else if (m.values().contains(c)) {
                if (!st.empty() && m.get(st.peek()) == c)
                    st.pop();
                else
                    return false;
            }
        }
        return st.empty();
    }
}

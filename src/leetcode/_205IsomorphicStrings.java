package leetcode;

import java.util.HashMap;

/**
 * Created by nagabharan on 29-Sep-16.
 */
public class _205IsomorphicStrings {
    static boolean isIsomorphic(String s, String t) {

        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if (map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "foo", t = "bar", x = "egg", y = "add";
        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphic(x, y));
    }
}

package leetMS;

import java.util.HashMap;

/**
 * Created by nagabharan on 0025, November 25, 2016.
 */
public class _13Roman2Int {
    public int sol(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int res = 0;
        int i = 0;
        for (i = 0; i < s.length() - 1; i++) {
            if (m.get(s.charAt(i)) >= m.get(s.charAt(i + 1)))
                res += m.get(s.charAt(i));
            else
                res -= m.get(s.charAt(i));
        }
        res += m.get(s.charAt(i));
        return res;
    }
}

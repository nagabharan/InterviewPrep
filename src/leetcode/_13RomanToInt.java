package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nagabharan on 19-Sep-16.
 */
public class _13RomanToInt {
    static int solution(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int res = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i));
            } else {
                res -= map.get(s.charAt(i));
            }
        }

        res += map.get(s.charAt(s.length() - 1));

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("CMLVI"));
    }
}

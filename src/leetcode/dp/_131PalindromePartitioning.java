package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nagabharan on 20-Oct-16.
 */
public class _131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        ArrayList<String> part = new ArrayList<>();
        addPP(s, 0, part, res);
        return res;
    }

    public void addPP(String s, int start, ArrayList<String> part, ArrayList<List<String>> res) {
        if (start == s.length()) {
            ArrayList<String> temp = new ArrayList<>(part);
            res.add(temp);
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalin(str)) {
                part.add(str);
                addPP(s, i, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

    public boolean isPalin(String s) {
        int b = 0, e = s.length() - 1;
        while (b < e) {
            if (s.charAt(b) != s.charAt(e))
                return false;
            else {
                b++;
                e--;
            }
        }
        return true;
    }
}

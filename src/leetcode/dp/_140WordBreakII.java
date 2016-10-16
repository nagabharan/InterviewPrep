package leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by nagabharan on 15-Oct-16.
 */
public class _140WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {

        List<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] != null) {
                for (String a : wordDict) {
                    int len = a.length();
                    int end = i + len;
                    if (end > s.length())
                        continue;
                    if (s.substring(i, end).equals(a)) {
                        if (dp[end] == null) {
                            dp[end] = new ArrayList<>();
                        }
                        dp[end].add(a);
                    }
                }
            }
        }

        List<String> res = new LinkedList<String>();
        if (dp[s.length()] == null)
            return res;

        ArrayList<String> t = new ArrayList<String>();
        dfs(dp, s.length(), res, t);
        return res;
    }

    public void dfs(List<String> dp[], int end, List<String> res, ArrayList<String> t) {
        if (end <= 0) {
            String p = t.get(t.size() - 1);
            for (int i = t.size() - 2; i >= 0; i--)
                p += " " + t.get(i);
            res.add(p);
            return;
        }
        for (String a : dp[end]) {
            t.add(a);
            dfs(dp, end - a.length(), res, t);
            t.remove(t.size() - 1);
        }
    }
}

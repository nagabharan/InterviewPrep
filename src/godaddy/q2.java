package godaddy;

import java.util.*;

/**
 * Created by nagabharan on 17-Sep-16.
 */
public class q2 {
    static String[] buildSubsequences(String s) {
        List<String> outputList = new ArrayList<String>();
        String[] arr = new String[outputList.size()];
        arr = outputList.toArray(arr);
        if (s == null || s.length() == 0 || s.length() > 15)
            return arr;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            getCombinations(s, n, i + 1, 0, outputList, "");
        }

        Collections.sort(outputList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        arr = new String[outputList.size()];
        arr = outputList.toArray(arr);
        return arr;
    }

    private static void getCombinations(String string, int n, int k, int index, List<String> outputList, String str) {
        if (n < k)
            return;
        if (str.length() == k) {
            outputList.add(new String(str));
            return;
        }
        for (int i = index; i < string.length(); i++) {
            str += string.charAt(i);
            getCombinations(string, n, k, i + 1, outputList, str);
            str = str.substring(0, str.length() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildSubsequences("ba")));
    }
}

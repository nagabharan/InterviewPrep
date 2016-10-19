package basic.warmup.snapchat;

import java.util.*;

/**
 * Created by nagabharan on 16-Oct-16.
 */
public class q1 {

    static ArrayList<String> wordDict;
    static HashMap<String, Integer> locMap;

    private static boolean wordInDict(String word) {
        for (String dictionaryWord : wordDict) {
            if (dictionaryWord.equals(word))
                return true;
        }
        return false;
    }

    public static boolean breakWords(String mainWord) {
        if (wordDict.size() == 0)
            return false;
        boolean[] flagArray = new boolean[mainWord.length()];

        for (int i = 1; i <= mainWord.length(); i++) {
            if (wordInDict(mainWord.substring(0, i))) {
                flagArray[i - 1] = true;
            }
            if (flagArray[i - 1]) {
                for (int j = i + 1; j <= mainWord.length(); j++) {
                    if (wordInDict(mainWord.substring(i, j))) {
                        flagArray[j - 1] = true;
                    }
                }
            }
        }
        return flagArray[mainWord.length() - 1];
    }

    static String[] simpleWords(String[] strArr) {
        wordDict = new ArrayList<>();
        locMap = new HashMap<>();
        fillMap(strArr);
        Arrays.sort(strArr, new StringSort());
        Map<String, Integer> outputMap = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            if (!breakWords(strArr[i])) {
                outputMap.put(strArr[i], locMap.get(strArr[i]));
            }
            wordDict.add(strArr[i]);
        }
        Map<String, Integer> sortedMap = sortByValue(outputMap);
        String[] outputArr = new String[sortedMap.size()];
        int counter = 0;
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            outputArr[counter] = entry.getKey();
            counter++;
        }
        return outputArr;
    }

    private static void fillMap(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            locMap.put(strArr[i], i);
        }
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        Map<String, Integer> outputMap = new TreeMap(new CompareValues(map));
        outputMap.putAll(map);
        return outputMap;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(simpleWords(
                new String[]{"chat", "ever", "snapchat", "snap", "salesperson", "per", "person", "sales", "son", "whatsoever", "what", "so"})));
    }

    public static class StringSort implements Comparator<String> {
        public int compare(String string1, String string2) {
            int difference = string1.length() - string2.length();
            return difference != 0 ? difference : string1.compareTo(string2);
        }
    }

    static class CompareValues implements Comparator {
        Map<String, Integer> map;

        public CompareValues(Map<String, Integer> map) {
            this.map = map;
        }

        public int compare(Object keyA, Object keyB) {
            Comparable comparableA = map.get(keyA);
            Comparable comparableB = map.get(keyB);
            return comparableA.compareTo(comparableB);
        }
    }
}

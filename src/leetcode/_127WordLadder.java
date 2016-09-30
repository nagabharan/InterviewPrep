package leetcode;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by nagabharan on 29-Sep-16.
 */
class WordNode {
    String word;
    int num;

    public WordNode(String word, int num) {
        this.word = word;
        this.num = num;
    }
}

public class _127WordLadder {
    static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<WordNode> q = new LinkedList<>();
        q.add(new WordNode(beginWord, 1));

        wordList.add(endWord);

        while (!q.isEmpty()) {
            WordNode top = q.remove();
            String word = top.word;

            if (word.equals(endWord))
                return top.num;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];

                    if (arr[i] != c)
                        arr[i] = c;

                    String newWord = new String(arr);
                    if (wordList.contains(newWord)) {
                        q.add(new WordNode(newWord, top.num + 1));
                        wordList.remove(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }
}

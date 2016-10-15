package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nagabharan on 15-Oct-16.
 */
public class _211AddSearchWord {
    TrieNode root;

    public _211AddSearchWord() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if (child.containsKey(c)) {
                t = child.get(c);
            } else {
                t = new TrieNode(c);
                child.put(c, t);
            }

            child = t.child;

            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(root.child, word, 0);
    }

    public boolean dfs(HashMap<Character, TrieNode> child, String word, int pos) {

        if (pos == word.length()) {
            return child.size() == 0;
        }

        char c = word.charAt(pos);

        if (child.containsKey(c)) {
            if (pos == word.length() - 1 && child.get(c).isLeaf)
                return true;
            return dfs(child.get(c).child, word, pos + 1);
        } else if (c == '.') {
            boolean res = false;

            for (Map.Entry<Character, TrieNode> ch : child.entrySet()) {
                if (pos == word.length() - 1 && ch.getValue().isLeaf)
                    return true;
                if (dfs(ch.getValue().child, word, pos + 1))
                    res = true;
            }
            return res;
        } else {
            return false;
        }
    }
}

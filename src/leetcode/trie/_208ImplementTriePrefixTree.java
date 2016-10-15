package leetcode.trie;

import java.util.HashMap;

/**
 * Created by nagabharan on 15-Oct-16.
 */

class TrieNode {

    char c;
    boolean isLeaf;
    HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();

    // Initialize your data structure here.
    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }
}

public class _208ImplementTriePrefixTree {
    private TrieNode root;

    public _208ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> child = root.child;

        for (int i = 0; i < word.length(); i++) {
            TrieNode t;
            char c = word.charAt(i);
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return t != null && t.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    public TrieNode searchNode(String word) {
        HashMap<Character, TrieNode> child = root.child;
        TrieNode t = null;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (child.containsKey(c)) {
                t = child.get(c);
                child = t.child;
            } else {
                return null;
            }
        }

        return t;
    }
}

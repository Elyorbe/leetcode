package trie;

/*
720. Longest Word in Dictionary

Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being added to the end of a previous word. 

 

Example 1:

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:

Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 30
words[i] consists of lowercase English letters.
 */

public class LongestWordInDictionary720 {

    private String result = "";

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        root.isWord = true;
        for (String word : words) {
            addWord(root, word);
        }
        dfs(new StringBuilder(), root);
        return result;
    }

    private void dfs(StringBuilder current, TrieNode node) {
        if (!node.isWord) {
            return;
        }
        if (current.length() > result.length()) {
            result = current.toString();
        }
        if (current.length() == result.length()) {
            if (current.compareTo(new StringBuilder(result)) < 0) {
                result = current.toString();
            }
        }
        for (char c : node.children.keySet()) {
            current.append(c);
            dfs(current, node.children.get(c));
            current.deleteCharAt(current.length() - 1);
        }
    }

    private void addWord(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isWord = true;
    }

}

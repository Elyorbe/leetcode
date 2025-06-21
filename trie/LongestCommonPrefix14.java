package trie;

/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
 */

public class LongestCommonPrefix14 {
    
    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        
        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        for (String word : strs) {
            if (word.isEmpty()) {
                return "";
            }
            addWord(root, word);
        }
        StringBuilder sb = new StringBuilder();
        TrieNode current = root;
        while(current != null && current.children.size() == 1 && !current.isEndOfWord) {
            Character c = current.children.keySet().iterator().next();
            sb.append(c);
            current = current.children.get(c);
        }
        return sb.toString();
    }

    private void addWord(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }
}

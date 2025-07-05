package trie;

/*
648. Replace Words

In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
 

Constraints:

1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.
 */

public class ReplaceWords648 {

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            addWord(root, word);
        }
        List<String> result = new ArrayList<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            result.add(searchWord(root, word));
        }
        return String.join(" ", result);
    }

    private String searchWord(TrieNode root, String word) {
        TrieNode current = root;
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return word;
            }
            current = current.children.get(c);
            result.append(c);
            if (current.isWord) {
                return result.toString();
            }
        }
        return word;
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

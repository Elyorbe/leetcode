package trie;

/*
677. Map Sum Pairs
Design a map that allows you to do the following:

Maps a string key to a given value.
Returns the sum of the values that have a key with a prefix equal to a given string.
Implement the MapSum class:

MapSum() Initializes the MapSum object.
void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
 

Example 1:

Input
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
Output
[null, null, 3, null, 5]

Explanation
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (apple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 

Constraints:

1 <= key.length, prefix.length <= 50
key and prefix consist of only lowercase English letters.
1 <= val <= 1000
At most 50 calls will be made to insert and sum.
 */

public class MapSumPairs677 {

    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isWord;
        private int value;

        public TrieNode() {
            children = new HashMap<>();
            isWord = false;
            value = 0;
        }
    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode current = root;
        for (char c : key.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isWord = true;
        current.value = val;
    }
    
    public int sum(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return 0;
            }
            current = current.children.get(c);
        }
        return sumValues(current);
    }

    private int sumValues(TrieNode node) {
        int sum = 0;
        if (node.isWord) {
            sum += node.value;
        }
        for (TrieNode current : node.children.values()) {
            sum += sumValues(current);
        }
        return sum;
    }

}

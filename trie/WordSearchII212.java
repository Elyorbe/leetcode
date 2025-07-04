package trie;

/*

212. Word Search II

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
 */
public class WordSearchII212 {

    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            addWord(root, word);
        }
        Set<String> result = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root, new StringBuilder(), result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][]board, int row, int col, TrieNode node, StringBuilder word, Set<String> result) {
        int rows = board.length;
        int cols = board[0].length;
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] == '.' 
            || !node.children.containsKey(board[row][col])) {
                return;
        }
        char c = board[row][col];
        board[row][col] = '.';
        node = node.children.get(c);
        word.append(c);
        if (node.isEndOfWord) {
            result.add(word.toString());
        }
        dfs(board, row - 1, col, node, word, result);
        dfs(board, row + 1, col, node, word, result);
        dfs(board, row, col - 1, node, word, result);
        dfs(board, row, col + 1, node, word, result);
        board[row][col] = c;
        word.deleteCharAt(word.length() - 1);
    }

    private void addWord(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

}

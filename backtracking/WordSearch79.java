package backtracking;

/*
79. Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?

 */

public class WordSearch79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = backtrack(board,  word, i, j, visited, 0);
                if (result) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int column, boolean[][] visited, int currentIndex) {
        if (currentIndex == word.length()) {
            return true;
        }
        if (row >= board.length || row < 0 || column >= board[0].length || column < 0) {
            return false;
        }
        if (visited[row][column]) {
            return false;
        }
        if (board[row][column] != word.charAt(currentIndex)) {
            return false;
        }
        visited[row][column] = true;
        boolean result = backtrack(board, word, row + 1, column, visited, currentIndex + 1) ||
                 backtrack(board, word, row, column + 1, visited, currentIndex + 1) ||
                 backtrack(board, word, row - 1, column, visited, currentIndex + 1) ||
                 backtrack(board, word, row, column - 1, visited, currentIndex + 1);
        visited[row][column] = false;
        return result;
    }

}

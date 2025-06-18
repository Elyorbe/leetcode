package backtracking;

/*
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
 */

public class NQueens51 {

    private Set<Integer> positiveDiagonal = new HashSet<>(); // r - c
    private Set<Integer> negativeDiagonal = new HashSet<>(); // r + c
    private Set<Integer> columns = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(result, board, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            List<String> current = new ArrayList<>();
            for (char[] r : board) {
                current.add(new String(r));
            }
            result.add(current);
            return;
        }
        for (int column = 0; column < board[0].length; column++) {
            if (positiveDiagonal.contains(row - column ) || negativeDiagonal.contains(row + column) || columns.contains(column)) {
                continue;
            }
            positiveDiagonal.add(row - column);
            negativeDiagonal.add(row + column);
            columns.add(column);
            board[row][column] = 'Q';
            bacNktrack(result, board, row + 1);
            positiveDiagonal.remove(row - column);
            negativeDiagonal.remove(row + column);
            columns.remove(column);
            board[row][column] = '.';
        }
    }

}

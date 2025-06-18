package backtracking;

/*
52. N-Queens II

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
 */

public class NQueens52 {

    private Set<Integer> positiveDiagonal = new HashSet<>(); // r - c
    private Set<Integer> negativeDiagonal = new HashSet<>();
    private Set<Integer> columns = new HashSet<>();

    public int totalNQueens(int n) {
        return backtrack(n, 0);
    }

    private int backtrack(int n, int row) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int column = 0; column < n; column++) {
            if (positiveDiagonal.contains(row - column ) || negativeDiagonal.contains(row + column) || columns.contains(column)) {
                continue;
            }
            positiveDiagonal.add(row - column);
            negativeDiagonal.add(row + column);
            columns.add(column);
            count += backtrack(n, row + 1);
            positiveDiagonal.remove(row - column);
            negativeDiagonal.remove(row + column);
            columns.remove(column);
        }
        return count;
    }

}

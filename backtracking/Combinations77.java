package backtracking;

/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n
 */

public class Combinations77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int n, int k, int currentN) {
        if (current.size() == k) {
            result.add(List.copyOf(current));
            return;
        }
        for (int i = currentN; i <= n; i++) {
            int remainingChoices = n - i + 1;
            int neededChoices = k - current.size();
            if (remainingChoices < neededChoices) {
                break;
            }
            current.add(i);
            backtrack(result, current, n, k, i + 1);
            current.removeLast();
        }
    }

}

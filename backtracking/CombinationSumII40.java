package backtracking;

/*
40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */

public class CombinationSumII40 {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(combinations, new ArrayList<>(), candidates, 0, target);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> current, int[] candidates, int index, int target) {
        if (target == 0) {
            combinations.add(new ArrayList<>(current));
        } else if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            backtrack(combinations, current, candidates, i + 1, target - candidates[i]);
            current.removeLast();
        }
    }

}

package backtracking;

/*
90. Subsets II

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order. 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/


public class SubsetsII90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(subsets, new ArrayList<>(), nums, 0);
        return subsets;
    }
    
    private void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int startIndex) {
        subsets.add(List.copyOf(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            backtrack(subsets, subset, nums, i + 1);
            subset.removeLast();
        }
    }

}

package backtracking;

/*
46. Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

 */

public class Permutations46 {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(permutations, permutation, nums, used);
        return permutations;
    }

    private void backtrack(List<List<Integer>> permutations, List<Integer> permutation, int[] nums, boolean[] used) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            permutation.add(nums[i]);
            used[i] = true;
            backtrack(permutations, permutation, nums, used);
            used[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

}

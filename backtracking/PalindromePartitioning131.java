package backtracking;

/*

131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
 */

public class PalindromePartitioning131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> current, String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(List.copyOf(current));
        }
        for (int i = startIndex; i < s.length();  i++) {
            if (isPalindrome(s, startIndex, i)) {
                current.add(s.substring(startIndex, i + 1));
                backtrack(result, current, s, i + 1);
                current.removeLast();
            }
            
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

package sliding.window;

/*
567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.


Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */

public class PermutationInString567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;    
        }
        Map<Character, Integer> s1Count = count(s1);
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            int windowSize = right - left + 1;
            if (windowSize == s1.length()) {
                Map<Character, Integer> windowCount = count(s2.substring(left, right + 1));
                if (s1Count.equals(windowCount)) {
                    return true;
                }
                left++;
            }
            right++;
        }
        return false;
    }

    private Map<Character, Integer> count(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }
    
}

package sliding.window;
/*

3. Longest Substring Without Repeating Characters 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> count = new HashMap<>();
        int i = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (!count.containsKey(rightChar) || count.get(rightChar) < 1) {
                longest = Math.max(longest, right - left + 1);
                count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);
                right++;
            } else {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }
        }
        return longest;
    }
 
}

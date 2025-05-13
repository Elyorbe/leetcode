package sliding.window;

/*
424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */

public class LongestRepeatingCharacterReplacement424 {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int right = 0;
        int longest = 0;
        int mostFrequent = 0;
        while (right < s.length()) {
            int windowSize = right - left + 1;
            char rightChar = s.charAt(right);
            int frequency = count.getOrDefault(rightChar, 0) + 1;
            count.put(rightChar, frequency);
            mostFrequent = Math.max(mostFrequent, frequency);
            right++;
            if (windowSize - mostFrequent > k) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            } else {
                longest = Math.max(longest, windowSize);
            }
        }
        return longest;
    }
}

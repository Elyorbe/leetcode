package sliding.window;

/*
76. Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

public class MinimumWindowSubstring76 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tCount = buildCount(t);
        Map<Character, Integer> sCount = new HashMap<>();
        int left = 0;
        int right = 0;
        int matched = 0;
        int start = 0;
        int end = 0;
        int minWindowSize = Integer.MAX_VALUE;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            sCount.put(rightChar, sCount.getOrDefault(rightChar, 0) + 1);
            if (tCount.containsKey(rightChar) && sCount.get(rightChar).equals(tCount.get(rightChar))) {
                matched++;
            }
            while (matched == tCount.size()) {
                int windowSize = right - left + 1;
                if (windowSize < minWindowSize) {
                    minWindowSize = right - left + 1;
                    start = left;
                    end = right;
                }
                char leftChar = s.charAt(left);
                sCount.put(leftChar, sCount.get(leftChar) - 1);
                if (tCount.containsKey(leftChar) && sCount.get(leftChar) < tCount.get(leftChar)) {
                    matched--;
                }
                left++;
            }
            right++;
        }
        if (minWindowSize == Integer.MAX_VALUE) {
            return "";
        }
        return  s.substring(start, end + 1);
    }

    private Map<Character, Integer> buildCount(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count;
    }

}

package backtracking;

/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfAPhoneNumber17 {

    private static final Map<Character, List<Character>> digitToLetters = Map.of(    
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
        );

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return combinations;
        }
        recurse(digits, new StringBuilder(), combinations, 0);
        return combinations;
    }

    private void recurse(String digits, StringBuilder combination, List<String> combinations, int currentIndex) {
        if(combination.length() >= digits.length()) {
            combinations.add(combination.toString());
            return;
        }

        for(int i = currentIndex; i < digits.length(); i++) {
            List<Character> letters = digitToLetters.get(digits.charAt(i));
            for(Character letter : letters) {
                combination.append(letter);
                recurse(digits,combination, combinations, i + 1);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }

}

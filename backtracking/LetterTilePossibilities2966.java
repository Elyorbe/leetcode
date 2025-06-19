package backtracking;

/*
1079. Letter Tile Possibilities
You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1
 

Constraints:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.
 */
public class LetterTilePossibilities2966 {

    private int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] letters = tiles.toCharArray();
        Arrays.sort(letters);
        boolean[] used = new boolean[letters.length];
        backtrack(letters, used);
        return count;
    }

    private void backtrack(char[] letters, boolean[] used) {
        for (int i = 0; i < letters.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && letters[i] == letters[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            count++;
            backtrack(letters, used);
            used[i] = false;
        }
    }

}

package stack;

/*

20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 
Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

public class ValidParentheses20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char peek = stack.peek();
                if (c == ')' && peek != '(') {
                    return false;
                }
                if (c == '}' && peek != '{') {
                    return false;
                }
                if (c == ']' && peek != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
 
}

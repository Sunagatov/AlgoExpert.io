package stack.easy;


import java.util.Map;
import java.util.Stack;

/**
 * Valid Parentheses Problem
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Stack, String
 * <p>
 * ----------------------------------------------------
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/valid-parentheses/">https://leetcode.com/problems/valid-parentheses/</a>
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given a string `s` containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * A string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Use a stack to track unmatched opening parentheses.
 * 2. Use a map to store pairs of closing and opening parentheses.
 * 3. Traverse each character in the string:
 *    - If the stack is not empty and the top of the stack matches the current closing parenthesis, pop the stack.
 *    - Otherwise, push the current character to the stack.
 * 4. At the end, if the stack is empty, the parentheses are valid.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where `n` is the length of the string.
 * - Each character is pushed or popped from the stack exactly once.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(n), where `n` is the length of the string.
 * - In the worst case, all characters could be pushed to the stack (e.g., "(((((((").
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Input: "()" -> Output: true
 * 2. Input: "()[]{}" -> Output: true
 * 3. Input: "(]" -> Output: false
 * 4. Input: "([)]" -> Output: false
 * 5. Input: "{[]}" -> Output: true
 * 6. Input: "" (empty string) -> Output: true
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - Empty string.
 * - Strings with unmatched parentheses (e.g., "((((" or ")))").
 * - Mixed types of parentheses in incorrect order (e.g., "(]").
 * <p>
 * ----------------------------------------------------
 */

public class ValidParenthesesWithOneStack {

    /**
     * Validates if a string contains valid parentheses.
     *
     * @param s The input string containing parentheses.
     * @return true if the parentheses are valid, false otherwise.
     */
    public boolean isValid(String s) {
        Stack<Character> charsStack = new Stack<>();
        Map<Character, Character> parenthesisPairs = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            Character matchingParenthesis = parenthesisPairs.get(currentChar);

            // If the stack is not empty and the current character is a closing parenthesis
            // that matches the top of the stack, pop the stack.
            if (!charsStack.isEmpty() && matchingParenthesis != null && charsStack.peek().equals(matchingParenthesis)) {
                charsStack.pop();
            } else {
                // Otherwise, push the current character onto the stack.
                charsStack.push(currentChar);
            }
        }

        // If the stack is empty, all parentheses are matched.
        return charsStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesesWithOneStack solution = new ValidParenthesesWithOneStack();

        // Test cases
        String[] testCases = {
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}",
                "",
                "[",
                "]",
                "{{{{",
                "}}}}",
                "{[()]}"
        };

        for (String testCase : testCases) {
            System.out.println("Input: \"" + testCase + "\" -> Output: " + solution.isValid(testCase));
        }
    }
}

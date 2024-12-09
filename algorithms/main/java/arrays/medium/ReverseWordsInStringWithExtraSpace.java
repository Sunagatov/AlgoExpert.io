package arrays.medium;


/**
 * 151. Reverse Words in a String
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Medium
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: String, Two Pointers
 * <p>
 * ----------------------------------------------------
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/reverse-words-in-a-string/">link</a>
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given an input string `s`, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in `s` will be separated by
 * at least one space. Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note:
 * - The returned string should not contain leading or trailing spaces.
 * - There should be only one space separating the words.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Split the words manually while ignoring leading, trailing, and extra spaces.
 * 2. Store words in a list as they are identified.
 * 3. Reverse the list of words to construct the final result.
 * 4. Append a single space between words during reconstruction.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the length of the input string.
 * - Iterating through the string to split words is O(n).
 * - Reversing the list and constructing the result is also O(n).
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(n), where n is the length of the input string.
 * - Space is used for the `words` list and the `StringBuilder` objects.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Standard case: "the sky is blue" -> "blue is sky the"
 * 2. Leading/trailing spaces: "  hello world  " -> "world hello"
 * 3. Multiple spaces: "a good   example" -> "example good a"
 * 4. Single word: "hello" -> "hello"
 * 5. Empty string: "" -> ""
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - Strings with only spaces (should return an empty string).
 * - Single words with spaces around them.
 * - Empty input string.
 * <p>
 * ----------------------------------------------------
 */
import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInStringWithExtraSpace {

    public String reverseWords(String s) {
        List<String> words = new ArrayList<>(); // To store individual words
        StringBuilder word = new StringBuilder(); // Temporary builder for the current word

        // Step 1: Extract words from the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar != ' ') {
                // Build the word if the current character is not a space
                word.append(currentChar);
            } else if (!word.isEmpty()) {
                // Add the word to the list and reset the builder
                words.add(word.toString());
                word.setLength(0); // Clear the StringBuilder
            }
        }

        // Add the last word (if any)
        if (!word.isEmpty()) {
            words.add(word.toString());
        }

        // Step 2: Reverse the words and construct the result
        StringBuilder result = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            result.append(words.get(i));
            if (i != 0) { // Avoid trailing spaces
                result.append(' ');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInStringWithExtraSpace solution = new ReverseWordsInStringWithExtraSpace();

        // Test cases
        String input1 = "the sky is blue";
        System.out.println("Input: \"" + input1 + "\"");
        System.out.println("Output: \"" + solution.reverseWords(input1) + "\"");

        String input2 = "  hello world  ";
        System.out.println("Input: \"" + input2 + "\"");
        System.out.println("Output: \"" + solution.reverseWords(input2) + "\"");

        String input3 = "a good   example";
        System.out.println("Input: \"" + input3 + "\"");
        System.out.println("Output: \"" + solution.reverseWords(input3) + "\"");

        String input4 = "hello";
        System.out.println("Input: \"" + input4 + "\"");
        System.out.println("Output: \"" + solution.reverseWords(input4) + "\"");

        String input5 = "";
        System.out.println("Input: \"" + input5 + "\"");
        System.out.println("Output: \"" + solution.reverseWords(input5) + "\"");
    }
}

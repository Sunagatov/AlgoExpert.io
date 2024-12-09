package two_pointers.medium;


/**
 * ----------------------------------------------------
 * 151. Reverse Words in a String
 * ----------------------------------------------------
 * <p>
 * Difficulty: Medium
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Two Pointers, String, Sorting (implicitly, due to string manipulation)
 * <p>
 * ----------------------------------------------------
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/reverse-words-in-a-string/description/">link</a>
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * <p>
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * <p>
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: Multiple spaces between words should be reduced to a single space.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^4
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * We can solve this in several ways. One efficient approach (inspired by the problem of
 * doing it "in-place" if strings were mutable) is:
 * <p>
 * 1. Trim leading and trailing spaces from the string.
 * 2. Reduce multiple spaces to a single space between words.
 * 3. Convert the string to a char array (or use a StringBuilder) for in-place modifications.
 * 4. Reverse the entire string.
 * 5. Then, reverse each word individually within the reversed string.
 * <p>
 * Steps:
 * - Convert s to a char array or StringBuilder.
 * - Trim spaces at start and end, and reduce multiple spaces:
 *   -> We can do this by scanning once and building a clean version of the string.
 * - Reverse the entire string.
 * - Reverse each word in place.
 * <p>
 * Time Complexity:
 * O(n), where n is the length of the string.
 * - Each character is visited a constant number of times (to trim/reduce spaces, reverse entire string, and reverse each word).
 * <p>
 * Space Complexity:
 * O(n), for the intermediate StringBuilder or char array used for manipulations.
 * Although if we consider the input as a mutable char array, it can be done in O(1) extra space.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Possible Follow-ups:
 * - Can we do it with O(1) extra space if the input is a mutable character array?
 *   Yes, by doing all operations in-place: trimming spaces, reversing whole string, and reversing words.
 * - How to handle other whitespace characters (tabs, etc.)?
 *   Adjust the conditions for skipping spaces accordingly.
 * - Could we handle punctuation differently?
 *   Yes, just change the conditions for what constitutes a "word."
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Standard case with multiple words: "the sky is blue" -> "blue is sky the"
 * 2. Leading/trailing spaces: "  hello world  " -> "world hello"
 * 3. Multiple spaces between words: "a good   example" -> "example good a"
 * 4. Single word: "hello" -> "hello"
 * 5. String with only spaces: "     " -> "" (empty string)
 * 6. Mixed alphanumeric: "my2 code  is4 you" -> "you is4 code my2"
 * <p>
 * Edge Cases:
 * - String length = 1: "a" -> "a"
 * - All spaces or only one word: ensure no extra spaces in output.
 * <p>
 * ----------------------------------------------------
 */

public class ReverseWordsInString {

    public static String reverseWords(String s) {
        // Convert to char array for in-place operations
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Step 1: Clean up spaces (trim and reduce multiple spaces to one)
        int len = removeExtraSpaces(chars, n);

        // Step 2: Reverse the entire trimmed string
        reverse(chars, 0, len - 1);

        // Step 3: Reverse each word
        int start = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }

        return new String(chars, 0, len);
    }

    // Remove leading, trailing and multiple spaces
    // Returns the length of the "cleaned" part
    private static int removeExtraSpaces(char[] chars, int n) {
        int slow = 0, fast = 0;

        // Skip leading spaces
        while (fast < n && chars[fast] == ' ') {
            fast++;
        }

        // Remove extra spaces in between
        while (fast < n) {
            if (chars[fast] != ' ') {
                chars[slow++] = chars[fast++];
            } else {
                // If space, check if next char is also space or end
                while (fast < n && chars[fast] == ' ') {
                    fast++;
                }
                // Add one space if it's not the end
                if (fast < n) {
                    chars[slow++] = ' ';
                }
            }
        }

        return slow;
    }

    // Reverse a portion of the char array [start, end]
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
                "the sky is blue",
                "  hello world  ",
                "a good   example",
                "hello",
                "     ",
                "my2 code  is4 you"
        };

        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            String result = reverseWords(input);
            System.out.println("Test case #" + (i + 1));
            System.out.println("Input: \"" + input + "\"");
            System.out.println("Output: \"" + result + "\"");
            System.out.println("------------------------------------");
        }
    }
}

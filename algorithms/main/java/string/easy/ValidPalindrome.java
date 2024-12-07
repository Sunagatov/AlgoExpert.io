package string.easy;

/**
 * 125. Valid Palindrome
 *
 * ----------------------------------------------------
 *
 * Difficulty: Easy
 *
 * ----------------------------------------------------
 *
 * Topics: Two Pointers, String
 *
 * ----------------------------------------------------
 *
 * Leetcode: https://leetcode.com/problems/valid-palindrome/description/
 *
 * ----------------------------------------------------
 * Time Complexity: O(n), where n is the length of the string.
 * - Each character in the string is visited at most once, as the pointers move towards each other.
 *
 * Space Complexity: O(1)
 * - The algorithm uses a constant amount of extra space, as it only uses two integer variables (left and right).
 *
 * ----------------------------------------------------
 * Description:
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads
 * the same forward and backward. Alphanumeric characters include letters
 * and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * ----------------------------------------------------
 *
 * Examples:
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters. Since an empty string reads the same forward and backward,
 * it is a palindrome.
 *
 * ----------------------------------------------------
 *
 * Algorithm:
 * - Use two pointers: one starting at the beginning of the string (left)
 *   and another at the end (right).
 * - Skip non-alphanumeric characters for both pointers.
 * - Compare the characters at the left and right pointers, ignoring case.
 * - If the pointers cross without finding a mismatch, the string is a palindrome.
 *
 */

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            // Skip non-alphanumeric characters
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "A man, a plan, a canal: Panama", // True
                "race a car", // False
                " ", // True (empty or whitespace-only strings are palindromes)
                "Taco cat", // True
                "Able was I, I saw Elba", // True
                "RACECAR", // True
                "ABBA", // True
                "TART", // False
                "12321", // True
                "123a321", // True
                "12#3a3%21" // True
        };

        System.out.println("Palindrome Check Results:");
        for (int i = 0; i < testCases.length; i++) {
            String testCase = testCases[i];
            boolean result = isPalindrome(testCase);
            System.out.printf("Test Case #%d: \"%s\" -> %b\n", i + 1, testCase, result);
        }
    }
}

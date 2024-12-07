package two_pointers;


public class ValidPalindrome{

    /**
     * This method checks whether a given string is a palindrome.
     * A palindrome is a word, phrase, or sequence that reads the same backward as forward.
     *
     * Algorithm:
     * - Use two pointers: one starting at the beginning of the string (left) and another at the end (right).
     * - Compare the characters at the left and right pointers.
     * - If at any point the characters differ, return false (not a palindrome).
     * - If the pointers cross without finding a mismatch, the string is a palindrome.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * - Each character in the string is visited at most once, as the pointers move towards each other.
     *
     * Space Complexity: O(1)
     * - The algorithm uses a constant amount of extra space, as it only uses two integer variables (left and right).
     *
     * Note: This implementation assumes that the input string is case-sensitive
     *       and considers only exact matches of characters.
     *
     * @param s The input string to be checked.
     * @return true if the input string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char lChar = s.charAt(l);
            char rChar = s.charAt(r);

            if (lChar != rChar) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] arg) {
        String[] testCase = {
                "RACECAR",
                "ABBA",
                "TART"
        };
        for (int k = 0; k < testCase.length; k++) {
            System.out.println("Test Case # " + (k + 1));
            System.out.println(isPalindrome(testCase[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
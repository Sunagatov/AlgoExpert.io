package string.easy;

/**
 * <p>
 * ----------------------------------------------------
 * <p>
 * 242. Valid Anagram (Using Optimized Hash Table)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: String, Hash Table, Array
 * <p>
 * ----------------------------------------------------
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/valid-anagram/">link</a>
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given two strings `s` and `t`, return true if `t` is an anagram of `s`, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. If the lengths of `s` and `t` are not equal, return false (they cannot be anagrams).
 * 2. Use an integer array of size 26 to store the frequency of each character.
 *    - Increment the count for each character in `s`.
 *    - Decrement the count for each character in `t`.
 * 3. After processing both strings, check if all values in the frequency array are zero.
 *    - If they are, return true (the strings are anagrams).
 *    - Otherwise, return false.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the length of the strings.
 * - Each character in both strings is processed once.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(1), constant space.
 * - The frequency array is of fixed size (26) regardless of the input size.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Standard case with anagrams: "listen", "silent" -> true
 * 2. Not anagrams: "hello", "world" -> false
 * 3. Different lengths: "abc", "abcd" -> false
 * 4. Empty strings: "", "" -> true
 * 5. Case-sensitive: "aBc", "cba" -> false
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - Empty strings (should return true).
 * - Strings with the same letters but different cases (case-sensitive comparison).
 * <p>
 * ----------------------------------------------------
 */

public class ValidAnagramWithHashTableOptimal {

    /**
     * Determines if two strings are anagrams using an optimized hash table approach.
     *
     * @param s The first string.
     * @param t The second string.
     * @return true if the two strings are anagrams, false otherwise.
     */
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int[] charFrequency = new int[26];

        // Update the frequency array based on the characters in s and t
        for (int i = 0; i < s.length(); i++) {
            charFrequency[s.charAt(i) - 'a']++;
            charFrequency[t.charAt(i) - 'a']--;
        }

        // Check if all frequencies are zero
        for (int frequency : charFrequency) {
            if (frequency != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagramWithHashTableOptimal solution = new ValidAnagramWithHashTableOptimal();

        // Test cases
        String s1 = "listen";
        String t1 = "silent";
        System.out.println("Test Case 1: " + solution.isAnagram(s1, t1)); // true

        String s2 = "hello";
        String t2 = "world";
        System.out.println("Test Case 2: " + solution.isAnagram(s2, t2)); // false

        String s3 = "abc";
        String t3 = "abcd";
        System.out.println("Test Case 3: " + solution.isAnagram(s3, t3)); // false

        String s4 = "";
        String t4 = "";
        System.out.println("Test Case 4: " + solution.isAnagram(s4, t4)); // true

        String s5 = "aBc";
        String t5 = "cba";
        System.out.println("Test Case 5: " + solution.isAnagram(s5, t5)); // false
    }
}

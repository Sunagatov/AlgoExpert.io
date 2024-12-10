package string.easy;

import java.util.Arrays;

/**
 * <p>
 * ----------------------------------------------------
 * <p>
 * 242. Valid Anagram (Using Sorting)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: String, Sorting
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
 * 1. If the lengths of the two strings are different, return false (they cannot be anagrams).
 * 2. Convert both strings into character arrays.
 * 3. Sort both character arrays.
 * 4. Compare the two sorted arrays using `Arrays.equals()`.
 *    - If they are equal, return true (the strings are anagrams).
 *    - Otherwise, return false.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n log n), where n is the length of the strings.
 * - Sorting the character arrays dominates the complexity.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(n), where n is the length of the strings.
 * - Additional space is used for the character arrays.
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
 * - Strings with special characters or numbers.
 * <p>
 * ----------------------------------------------------
 */

public class ValidAnagramWithSorting {

    /**
     * Determines if two strings are anagrams using sorting.
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

        // Convert strings to character arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Sort both character arrays
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Compare the sorted arrays
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        ValidAnagramWithSorting solution = new ValidAnagramWithSorting();

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

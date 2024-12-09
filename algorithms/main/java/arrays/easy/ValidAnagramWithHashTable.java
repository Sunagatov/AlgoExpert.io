package arrays.easy;

import java.util.HashMap;

/**
 * <p>
 * ----------------------------------------------------
 * <p>
 * 242. Valid Anagram (Using Hash Table)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: String, Hash Table
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
 * 1. If the lengths of `s` and `t` are not equal, return false.
 * 2. Use two Hash Maps (`countS` and `countT`) to count the frequency of each character in `s` and `t`.
 * 3. Iterate through the characters of both strings and populate the Hash Maps.
 * 4. Compare the two Hash Maps:
 *    - If they are equal, return true (the strings are anagrams).
 *    - Otherwise, return false.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the length of the strings.
 * - Populating the Hash Maps takes O(n) time.
 * - Comparing the two Hash Maps takes O(n) time.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(n), where n is the length of the strings.
 * - The Hash Maps store up to n entries (in the worst case where all characters are unique).
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

public class ValidAnagramWithHashTable {

    /**
     * Determines if two strings are anagrams using Hash Tables.
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

        // Hash Maps to count character frequencies
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        // Populate the Hash Maps
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            countS.put(charS, countS.getOrDefault(charS, 0) + 1);
            countT.put(charT, countT.getOrDefault(charT, 0) + 1);
        }

        // Compare the Hash Maps
        return countS.equals(countT);
    }

    public static void main(String[] args) {
        ValidAnagramWithHashTable solution = new ValidAnagramWithHashTable();

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

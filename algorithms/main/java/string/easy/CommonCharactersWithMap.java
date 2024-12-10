package string.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ----------------------------------------------------
 * Common Characters in Strings
 * ----------------------------------------------------
 * <p>
 * Difficulty: Medium
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given an array of strings, find all characters that are common in all the strings.
 * The result should only include characters that appear in every string at least once.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n * m), where `n` is the number of strings and `m` is the length of the longest string.
 * - We iterate through every character in every string, resulting in `O(n * m)`.
 * <p>
 * Space Complexity:
 * O(m + k), where `m` is the size of the longest string, and `k` is the number of unique characters.
 * - `m` is for the `Set` used for each string.
 * - `k` is for the `Map` that stores character counts.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Examples:
 * Example 1:
 * Input: ["bella", "label", "roller"]
 * Output: ["e", "l"]
 * Explanation: The characters 'e' and 'l' are common across all strings.
 * <p>
 * Example 2:
 * Input: ["cool", "lock", "cook"]
 * Output: ["c", "o"]
 * Explanation: The characters 'c' and 'o' are common across all strings.
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Use a `Map<Character, Integer>` to track the frequency of characters appearing in all strings.
 * 2. For each string:
 *    - Use a `Set<Character>` to ensure that each character is only counted once per string.
 *    - Update the frequency count in the map.
 * 3. After processing all strings, filter characters whose frequency equals the total number of strings.
 * 4. Return the common characters as a list.
 * ----------------------------------------------------
 */

class CommonCharactersWithMap {

    /**
     * Finds all characters common to all strings in the given array.
     *
     * @param strings Array of strings to process.
     * @return Array of common characters.
     */
    public String[] commonCharacters(String[] strings) {
        Map<Character, Integer> charCounts = new HashMap<>(); // Map to track character frequencies

        // Iterate through each string in the array
        for (String currentString : strings) {
            Set<Character> currentCharSet = new HashSet<>(); // Set to track unique characters in the current string

            // Process each character in the string
            for (Character currentChar : currentString.toCharArray()) {
                // If the character has not been processed for this string, add it to the set
                if (currentCharSet.add(currentChar)) {
                    // Update the character count in the map
                    charCounts.put(currentChar, charCounts.getOrDefault(currentChar, 0) + 1);
                }
            }
        }

        // Filter characters that appear in all strings and convert them to an array
        return charCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == strings.length) // Only include characters that appear in all strings
                .map(entry -> entry.getKey().toString()) // Convert each character to a string
                .toArray(String[]::new); // Convert the stream to an array
    }

    public static void main(String[] args) {
        CommonCharactersWithMap program = new CommonCharactersWithMap();

        // Test case 1
        String[] strings1 = {"bella", "label", "roller"};
        System.out.println("Common Characters: " + Arrays.toString(program.commonCharacters(strings1)));
        // Output: ["e", "l"]

        // Test case 2
        String[] strings2 = {"cool", "lock", "cook"};
        System.out.println("Common Characters: " + Arrays.toString(program.commonCharacters(strings2)));
        // Output: ["c", "o"]

        // Test case 3
        String[] strings3 = {"abc", "def", "ghi"};
        System.out.println("Common Characters: " + Arrays.toString(program.commonCharacters(strings3)));
        // Output: []

        // Edge case
        String[] strings4 = {"aaa", "aaa", "aaa"};
        System.out.println("Common Characters: " + Arrays.toString(program.commonCharacters(strings4)));
        // Output: ["a"]
    }
}

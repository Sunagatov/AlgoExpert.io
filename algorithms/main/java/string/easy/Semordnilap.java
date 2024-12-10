package string.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ----------------------------------------------------
 * Semordnilap Finder
 * ----------------------------------------------------
 * <p>
 * Difficulty: Medium
 * ----------------------------------------------------
 * <p>
 * Description:
 * A semordnilap is a word that forms another word when reversed. For example, "stressed" and "desserts" are semordnilaps.
 * Given an array of unique strings `words`, return all pairs of semordnilaps in the form of a list of lists.
 * A pair is considered valid if:
 * 1. Both words exist in the input array.
 * 2. One word is the reverse of the other.
 * 3. A word cannot form a semordnilap with itself.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n * m), where `n` is the number of words and `m` is the average length of the words.
 * - Reversing each word takes O(m).
 * - Checking for the presence of a word in the set is O(1).
 * - Iterating through the array of words is O(n).
 * <p>
 * Space Complexity:
 * O(n), where `n` is the number of words in the array.
 * - We store all the words in a `Set`.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: words = ["stressed", "desserts", "hello", "olleh"]
 * Output: [["stressed", "desserts"], ["hello", "olleh"]]
 * <p>
 * Example 2:
 * Input: words = ["abcd", "dcba", "xyz", "zyx"]
 * Output: [["abcd", "dcba"], ["xyz", "zyx"]]
 * <p>
 * Example 3:
 * Input: words = ["abc", "cba", "abc"]
 * Output: [["abc", "cba"]]
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Convert the input `words` array into a `Set` for quick lookups.
 * 2. Iterate through each word in the array:
 *    - Reverse the word.
 *    - Check if the reversed word exists in the set.
 *    - Ensure that the word is not the same as its reverse.
 *    - If both conditions are met:
 *      - Add the pair `[word, reversedWord]` to the result.
 *      - Remove both words from the set to avoid duplication.
 * 3. Return the resulting list of pairs.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Possible Follow-ups:
 * - How would you handle case-insensitive semordnilaps?
 * - How would the solution change if duplicates were allowed in the input array?
 * - What if the input words contain spaces or special characters?
 * ----------------------------------------------------
 */

class Semordnilap {

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        // Convert the input words into a set for efficient lookups
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // Iterate through each word in the input array
        for (String word : words) {
            // Reverse the current word
            String reversedWord = new StringBuilder(word).reverse().toString();

            // Check if the reversed word is present in the set and is not the same as the original word
            if (wordsSet.contains(word) && wordsSet.contains(reversedWord) && !word.equals(reversedWord)) {
                // Add the pair [word, reversedWord] to the result
                result.add(new ArrayList<>(List.of(word, reversedWord)));

                // Remove both words from the set to prevent duplicate pairs
                wordsSet.remove(word);
                wordsSet.remove(reversedWord);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Semordnilap program = new Semordnilap();

        // Test case 1
        String[] words1 = {"stressed", "desserts", "hello", "olleh"};
        System.out.println("Semordnilaps: " + program.semordnilap(words1));
        // Output: [["stressed", "desserts"], ["hello", "olleh"]]

        // Test case 2
        String[] words2 = {"abcd", "dcba", "xyz", "zyx"};
        System.out.println("Semordnilaps: " + program.semordnilap(words2));
        // Output: [["abcd", "dcba"], ["xyz", "zyx"]]

        // Test case 3
        String[] words3 = {"abc", "cba", "abc"};
        System.out.println("Semordnilaps: " + program.semordnilap(words3));
        // Output: [["abc", "cba"]]

        // Edge case: Empty input
        String[] words4 = {};
        System.out.println("Semordnilaps: " + program.semordnilap(words4));
        // Output: []

        // Edge case: No semordnilaps
        String[] words5 = {"apple", "banana", "cherry"};
        System.out.println("Semordnilaps: " + program.semordnilap(words5));
        // Output: []
    }
}

